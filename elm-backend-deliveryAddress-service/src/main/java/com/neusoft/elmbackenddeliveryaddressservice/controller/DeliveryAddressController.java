package com.neusoft.elmbackenddeliveryaddressservice.controller;


import com.neusoft.elmbackendcommon.common.BaseResponse;
import com.neusoft.elmbackendcommon.common.ErrorCode;
import com.neusoft.elmbackendcommon.common.ResultUtils;
import com.neusoft.elmbackendcommon.exception.BusinessException;
import com.neusoft.elmbackenddeliveryaddressservice.service.DeliveryAddressService;
import com.neusoft.elmbackendmodel.model.bo.DeliveryAddress;
import com.neusoft.elmbackendmodel.model.vo.DeliveryAddressVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class DeliveryAddressController {
    @Autowired
    private DeliveryAddressService deliveryAddressService;

    @GetMapping("/lists/{userId}")
    public BaseResponse<List<DeliveryAddressVo>> listDeliveryAddressByUserId(@PathVariable(value = "userId") String userId)
            throws Exception {
        if (userId == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "请求参数不可为空");
        }
        List<DeliveryAddressVo> deliveryAddressVoList = deliveryAddressService.listDeliveryAddressByUserId(userId);
        if (deliveryAddressVoList != null) {
            return ResultUtils.success(deliveryAddressVoList);
        } else {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "数据库操作失败，获取当前用户配送地址列表失败");
        }

    }

    @GetMapping("/{daId}")
    public BaseResponse<DeliveryAddressVo> getDeliveryAddressById(@PathVariable(value = "daId") Integer daId) throws
            Exception {
        if (daId == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "请求参数不可为空");
        }
        DeliveryAddressVo deliveryAddressVo = deliveryAddressService.getDeliveryAddressById(daId);
        if (deliveryAddressVo != null) {
            return ResultUtils.success(deliveryAddressVo);
        } else {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "数据库操作失败，获取当前用户的某个配送地址失败");
        }
    }

    @PostMapping("/newDA/{deliveryAddress}")
    public BaseResponse<Integer> saveDeliveryAddress(@RequestParam("userId") String userId,
                                                     @RequestParam("contactName") String contactName,
                                                     @RequestParam("contactSex") Integer contactSex,
                                                     @RequestParam("contactTel") String contactTel,
                                                     @RequestParam("address") String address) throws Exception {
        if (userId == null || contactName == null || contactSex == null || contactTel == null || address == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "请求参数不可为空");
        }

        if (contactSex != 1 && contactSex != 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "性别参数应该为1 or 0");
        }
        if (contactTel.length() != 11) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "联系电话应该为11位");
        }
        if (address.charAt(0) != '0' && contactTel.charAt(0) != '1') {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "联系电话应该以1 或 0开头");
        }
        Integer result = deliveryAddressService.saveDeliveryAddress(userId, contactName, contactSex, contactTel, address);
        if (result.equals(1)) {
            return ResultUtils.success(result);
        } else {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "数据库操作失败，新建配送地址失败");
        }
    }

    @PostMapping("/updated-DA/{deliveryAddress}")
    public BaseResponse<Integer> updateDeliveryAddress(@RequestParam("daId") Integer daId,
                                                       @RequestParam("contactName") String contactName,
                                                       @RequestParam("contactSex") Integer contactSex,
                                                       @RequestParam("contactTel") String contactTel,
                                                       @RequestParam("address") String address) throws Exception {
        if (daId == null || contactName == null || contactSex == null || contactTel == null || address == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "请求参数不可为空");
        }
        if (contactSex != 1 && contactSex != 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "性别参数应该为1 or 0");
        }
        if (contactTel.length() != 11) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "联系电话应该为11位");
        }
        if (contactTel.charAt(0) != '0' && contactTel.charAt(0) != '1') {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "联系电话应该以1 或 0开头");
        }
        Integer result = deliveryAddressService.updateDeliveryAddress(daId, contactName, contactSex, contactTel, address);
        if (result.equals(1)) {
            return ResultUtils.success(result);
        } else {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "数据库操作失败，更新配送地址失败");
        }
    }

    @DeleteMapping
    public BaseResponse<Integer> removeDeliveryAddress(@RequestParam("deliveryAddress") DeliveryAddress deliveryAddress) throws Exception {
        if (deliveryAddress.getDaId() == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "请求参数不可为空");
        }
        Integer result = deliveryAddressService.removeDeliveryAddress(deliveryAddress.getDaId());
        if (result.equals(1)) {
            return ResultUtils.success(result);
        } else {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "数据库操作失败，移除配送地址失败");
        }
    }
}