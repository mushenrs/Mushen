package me.mushen.athena.util;

import me.mushen.thrift.base.Failure;
import me.mushen.thrift.base.Result;
import me.mushen.thrift.base.Status;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * @Desc
 * @Author Remilia
 * @Create 2016-07-15
 */
public class BaseThriftUtil {
    // default
    private static final int Default_Failure_Code = 1000;
    private static final String Default_Failure_Name = "Default";
    private static final String Default_Failure_Desc = "Unknown";
    // exception
    private static final int Exception_Failure_Code = 9000;
    private static final String Exception_Failure_Name = "Exception";


    /**
     * Success Result
     * @return
     */
    public static Result successResult(){
        return new Result(Status.SUCC);
    }

    /**
     * Failure Result
     * @return 返回默认的未知错误
     */
    public static Result failureResult(){
        return failureResult(Default_Failure_Code, Default_Failure_Name, Default_Failure_Desc);
    }

    /**
     * Failure Result
     * @param description 错误描述
     * @return
     */
    public static Result failureResult(String description){
        return failureResult(Default_Failure_Code, Default_Failure_Name, description);
    }

    /**
     * Failure Result
     * @param exp 异常错误
     * @return
     */
    public static Result failureResult(Exception exp){
        return failureResult(Exception_Failure_Code, Exception_Failure_Name, exp.getMessage());
    }

    /**
     * Failure Result
     * @param code 错误码
     * @param name 错误名称
     * @param description 错误描述
     * @return
     */
    public static Result failureResult(int code, String name, String description){
        Failure failure = new Failure(  code,
                                        Optional.ofNullable(name).orElse(""),
                                        Optional.ofNullable(description).orElse(""));

        return failureResult(failure);
    }

    /**
     * Failure Result
     * @param failure 失败信息
     * @return
     */
    public static Result failureResult(Failure failure){
        return failureResult(Collections.singletonList(failure));
    }

    /**
     * Failure Result
     * @param failureList 失败信息列表
     * @return
     */
    public static Result failureResult(List<Failure> failureList){
        Result result = new Result(Status.FAIL);
        result.setFailureList(failureList);

        return result;
    }
}
