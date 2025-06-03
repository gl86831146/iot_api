package top.gsc.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.*;
import top.gsc.convert.DeviceConvert;
import top.gsc.dto.DeviceDTO;
import top.gsc.entity.Device;
import top.gsc.framework.common.utils.PageResult;
import top.gsc.framework.common.utils.Result;
import top.gsc.query.DeviceQuery;
import top.gsc.service.DeviceService;
import top.gsc.vo.DeviceVO;

import java.util.List;
import java.util.Map;

/**
 * 设备表
 *
 * @author moqi
 */
@RestController
@RequestMapping("api/device")
@Tag(name = "设备模块")
@AllArgsConstructor
public class DeviceController {

}