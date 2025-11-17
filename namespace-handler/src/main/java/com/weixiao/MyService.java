package com.weixiao;

import java.util.Map;

/**
 * @author changzheng
 * @date 2025年11月17日 09:59
 */
public class MyService {

    private String serviceName;
    private MyDAO defaultDao;
    private Map<String, MyDAO> daoRegistry;

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public MyDAO getDefaultDao() {
        return defaultDao;
    }

    public void setDefaultDao(MyDAO defaultDao) {
        this.defaultDao = defaultDao;
    }

    public Map<String, MyDAO> getDaoRegistry() {
        return daoRegistry;
    }

    public void setDaoRegistry(Map<String, MyDAO> daoRegistry) {
        this.daoRegistry = daoRegistry;
    }

    @Override
    public String toString() {
        return "MyService{" +
                "serviceName='" + serviceName + '\'' +
                ", defaultDao=" + defaultDao +
                ", daoRegistry=" + daoRegistry +
                '}';
    }
}
