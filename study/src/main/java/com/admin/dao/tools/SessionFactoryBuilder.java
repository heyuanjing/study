package com.admin.dao.tools;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SessionFactoryBuilder {

    @Autowired
    private SessionFactory sessionFactory;

    public Object load(Class<?> claz, Integer id) {
        Session session = getSession();
        Transaction tran = session.beginTransaction();

        Object returnObj = session.load(claz, id);

        tran.commit();
        closeSession(session);
        return returnObj;
    }

    public Object get(Class<?> claz, Integer id) {
        Session session = getSession();
        Transaction tran = session.beginTransaction();

        Object returnObj = session.get(claz, id);

        tran.commit();
        closeSession(session);

        return returnObj;
    }

    public List<?> find(Object[] params, String hql) {
        Session session = getSession();
        Transaction tran = session.beginTransaction();

        Query query = session.createQuery(hql);
        if (params != null && params.length > 0) {
            for (int i = 0; i < params.length; i++) {
                query.setParameter(i, params[i]);
            }
        }
        List<?> list = query.list();

        tran.commit();
        closeSession(session);

        return list;
    }

    public void add(Object paramObj) {
        Session session = getSession();
        Transaction tran = session.beginTransaction();

        session.save(paramObj);

        tran.commit();
        closeSession(session);
    }

    public void save(Object paramObj) {
        Session session = getSession();
        Transaction tran = session.beginTransaction();

        session.saveOrUpdate(paramObj);

        tran.commit();
        closeSession(session);
    }

    public List<?> list(String hql) {
        Session session = getSession();
        Transaction tran = session.beginTransaction();

        Query query = session.createQuery(hql);
        List<?> list = query.list();

        tran.commit();
        closeSession(session);

        return list;
    }

    public void delete(Class<?> claz, Integer id) {
        // 1.建立一个与数据库进行连接的会话对象
        Session session = getSession();
        // 2.开启一个数据库事务
        Transaction tran = session.beginTransaction();
        // 3.执行数据库的操作
        Object object = get(claz, id);
        session.delete(object);
        // 4.提交事务（保证数据库原子性操作）
        tran.commit();
        // 5.关闭与数据库连接的会话对象
        closeSession(session);
    }

    public void batchDelete(Class<?> claz, List<Integer> idList) {
        Session session = getSession();
        Transaction tran = session.beginTransaction();

        String hql = "delete " + claz.getSimpleName() + " where id in(?)";
        Query query = session.createQuery(hql);
        query.setParameter(0, StringUtils.join(idList, ","));
        query.executeUpdate();

        tran.commit();
        closeSession(session);
    }

    private Session getSession() {
        Session session = null;
        if (null == session || !session.isOpen()) {
            session = sessionFactory.openSession();
        }
        return session;
    }

    private void closeSession(Session session) {
        if (null != session && session.isOpen()) {
            session.close();
        }
    }

}