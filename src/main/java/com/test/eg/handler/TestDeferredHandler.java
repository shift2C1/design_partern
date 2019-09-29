package com.test.eg.handler;

import com.test.eg.entity.DeferredResultResponse;
import com.test.eg.service.DeferredResultService;
import jdk.nashorn.internal.runtime.options.Options;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

@RestController
@RequestMapping("/deferred-result")
public class TestDeferredHandler {
    //deferredresult:延迟结果
    @Autowired
    private DeferredResultService deferredResultService;
    private String requestId="hahah";
    @RequestMapping("/get")
    public DeferredResult<DeferredResultResponse> get(@RequestParam(value = "timeout", required = false, defaultValue = "10000") Long timeout) {
        DeferredResult<DeferredResultResponse> deferredResult = new DeferredResult<>(timeout);
        deferredResultService.process(requestId, deferredResult);
        return deferredResult;
    }

    /**
     * 设置DeferredResult对象的result属性，模拟异步操作
     * @param desired
     * @return
     */
    @GetMapping(value = "/result")
    public String settingResult(@RequestParam(value = "desired", required = false, defaultValue = "成功") String desired) {
        DeferredResultResponse deferredResultResponse = new DeferredResultResponse();
        if (DeferredResultResponse.Msg.SUCCESS.getDesc().equals(desired)){
            deferredResultResponse.setCode(HttpStatus.OK.value());
            deferredResultResponse.setMsg(desired);
        }else{
            deferredResultResponse.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            deferredResultResponse.setMsg(DeferredResultResponse.Msg.FAILED.getDesc());
        }
        deferredResultService.settingResult(requestId, deferredResultResponse);

        return "Done";
    }

}
