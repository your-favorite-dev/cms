package com.boingo.cms.util;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ClassChangeComparator {

    public List<String> auditObject(Object firstObj, Object secondObj) throws IllegalAccessException {

        List<String> differenceList = Lists.newArrayList();
        if(null != firstObj && null != secondObj){
            Field [] object1Fields = firstObj.getClass().getDeclaredFields();
            boolean isSearching = true;
            while(isSearching){
                for(Field field:object1Fields) {
                    field.setAccessible(true);
                    Object value1 = field.get(firstObj);
                    Object value2 = field.get(secondObj);
                    if (isString(value1, value1)) {
                        getStringDifference(differenceList, field, value1, value2);
                    } else if (!(value1 instanceof Collection) && !(value1 instanceof Map)) {
                        List<String> nestedList = auditObject(value1,value2);
                        differenceList = Stream.concat(nestedList.stream(), differenceList.stream()).collect(Collectors.toList());
                    }
                    isSearching = false;
                }

            }
        }


        return differenceList;
    }

    private void getStringDifference(List<String> differenceList, Field field, Object value1, Object value2) {
        if(!StringUtils.equals(((String) value1),((String) value2))){
            differenceList.add(field.getName() + "changed from " + value1 + " to " + value2);
        }
    }

    private boolean isString(Object value1, Object value2) {
        return value1 instanceof String && value2 instanceof String;
    }
}
