package top.autuan.templatebusinesssupport.base.service;


import top.autuan.templatebusinesssupport.base.entity.LogOper;

public interface LogOperService {
    /**
     * 异步保存操作日志
     * @param logOper 要保存的数据
     */
    void saveLogAsync(LogOper logOper);

    /**
     * 保存操作日志
     * @param logOper 要保存的数据
     */
    void saveLog(LogOper logOper);
}
