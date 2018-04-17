package com.ch.rule;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.tuple.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by hao on 2018/4/16.
 *  verified和verifyFlag字段用来做规则适配，给前端展示用
 *  新增verified_r和verifyFlag_r进行存储
 * if(copyrightInfo!=1&&verified=1&&(verifyFlag<2&&verifyFlag>5)){
 *     verified=4;
 * }
 *
 * verified=4:copyrightInfo=^1&&verified=1&&verifyFlag=^(2|3|4|5)
 */
public class UserDefinedReload implements IReloadWeMedia {

    private static final Logger logger = LoggerFactory.getLogger(UserDefinedReload.class);

    private List<ParamsMatch> paramsMatches = Lists.newArrayList();
    private List<ParamsSetter> paramsSetters = Lists.newArrayList();
    public static List<Pair<String,List<String>>> allRules = Lists.newArrayList();

    public UserDefinedReload() {
        paramsMatches.add(new ParamsMatch() {
            @Override
            public boolean matched(WeMedia weMedia, String rule) throws Exception {
                String name = rule.split("=")[0];
                String value = rule.split("=")[1];
                Object weMediaValue = null;

                if (value.contains("^")){
                    value = value.substring(1);
                    weMediaValue = weMedia.getClass().getMethod(WeMediaMethodEnum.get(name).getGet()).invoke(weMedia);
                    return !Pattern.matches(value,String.valueOf(weMediaValue));
                }else {
                    weMediaValue = weMedia.getClass().getMethod(WeMediaMethodEnum.get(name).getGet()).invoke(weMedia);
                    return Pattern.matches(value,String.valueOf(weMediaValue));
                }
            }
        });
        paramsSetters.add(new ParamsSetter() {
            @Override
            public void setter(WeMedia weMedia, String rule) throws Exception {
                String name = rule.split("=")[0];
                String value = rule.split("=")[1];
                Class clazz = weMedia.getClass().getMethod(WeMediaMethodEnum.get(name).getGet()).getReturnType();
                if (clazz == Integer.class || clazz == int.class){
                    weMedia.getClass().getMethod(WeMediaMethodEnum.get(name).getSet(),clazz).invoke(weMedia,Integer.valueOf(value));
                }else if (clazz == Long.class || clazz == long.class){
                    weMedia.getClass().getMethod(WeMediaMethodEnum.get(name).getSet(),clazz).invoke(weMedia,Long.valueOf(value));
                }else if (clazz == Boolean.class || clazz == boolean.class){
                    weMedia.getClass().getMethod(WeMediaMethodEnum.get(name).getSet(),clazz).invoke(weMedia,Boolean.valueOf(value));
                }else {
                    weMedia.getClass().getMethod(WeMediaMethodEnum.get(name).getSet(),clazz).invoke(weMedia,value);
                }
            }
        });
        loadRules();
    }

    @Override
    public void reload(List<WeMedia> weMedias) throws Exception {
        for (WeMedia weMedia : weMedias){
            for (Pair<String,List<String>> rule : allRules){
                boolean matched = true;
                try {
                    for (String one : rule.getRight()){
                        for(ParamsMatch paramsMatch : paramsMatches){
                            if (!paramsMatch.matched(weMedia,one)){
                                matched =false;
                                break;
                            }
                        }
                    }
                    if (matched){
                        for (ParamsSetter paramsSetter : paramsSetters){
                            paramsSetter.setter(weMedia,rule.getLeft());
                        }
                    }
                } catch (Exception e) {
                    logger.error("",e);
                }
            }
        }

    }

    void loadRules(){
        String[] array = new String[]{"verifyFlag=4:copyrightInfo=^2&&verified=1&&verifyFlag=^(2|3|4|5)"
                ,"verified=0:copyrightInfo=2&&verified=1"};
        List<Pair<String,List<String>>> newRules = Lists.newArrayList();
        if (array.length>0){
            for (final String rule : array){
                String setter = rule.split(":")[0];
                String matches = rule.split(":")[1];
                String[] matchList = matches.split("&&");
                List<String> paramsMatches = Lists.newArrayList();
                for (String matchRule : matchList){
                    paramsMatches.add(matchRule);
                }
                newRules.add(Pair.of(setter,paramsMatches));
            }
            this.allRules = newRules;
        }
    }


}
