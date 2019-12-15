package com.interceptor;

import com.Employee;
import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;

import java.io.Serializable;
import java.util.Iterator;

public class MyInterceptor extends EmptyInterceptor {

    @Override
    public boolean onFlushDirty(Object entity, Serializable id, Object[] currentState, Object[] previousState, String[] propertyNames, Type[] types) {

        if(entity instanceof Employee){
            System.out.println("Employee object flush");
        }

        return super.onFlushDirty(entity, id, currentState, previousState, propertyNames, types);
    }


    @Override
    public void onDelete(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {


        if(entity instanceof Employee){
            System.out.println("Employee object delete");
        }


        super.onDelete(entity, id, state, propertyNames, types);
    }

    @Override
    public void preFlush(Iterator entities) {
        System.out.println("pre flush");
        super.preFlush(entities);
    }

    @Override
    public void postFlush(Iterator entities) {
        System.out.println("post flush");
        super.postFlush(entities);
    }

    @Override
    public boolean onLoad(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
        if(entity instanceof Employee){
            System.out.println("Employee object onload");
        }
        return super.onLoad(entity, id, state, propertyNames, types);
    }

    @Override
    public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
        if(entity instanceof Employee){
            System.out.println("Employee object onsave");
        }
        return super.onSave(entity, id, state, propertyNames, types);
    }
}
