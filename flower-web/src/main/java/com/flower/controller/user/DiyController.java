package com.flower.controller.user;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.flower.base.ResponseResult;
import com.flower.dto.DiyWorksDto;
import com.flower.entity.DiyMaterial;
import com.flower.entity.DiyPackaging;
import com.flower.entity.DiyWorkItem;
import com.flower.entity.DiyWorks;
import com.flower.service.DiyMaterialService;
import com.flower.service.DiyPackagingService;
import com.flower.service.DiyWorkItemService;
import com.flower.service.DiyWorksService;
import com.flower.utils.RequestHolder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/diy")
@Slf4j
@RequiredArgsConstructor
public class DiyController {

    private final DiyMaterialService diyMaterialService;
    private final DiyPackagingService diyPackagingService;
    private final DiyWorksService diyWorksService;
    private final DiyWorkItemService diyWorkItemService;

    @GetMapping("/materials")
    public ResponseResult<List<DiyMaterial>> materials(@RequestParam(name = "type", required = false) String type) {
        LambdaQueryWrapper<DiyMaterial> wrapper = new LambdaQueryWrapper<>();
        if (type != null) {
            wrapper.eq(DiyMaterial::getType, type);
        }
        return ResponseResult.success(diyMaterialService.list(wrapper));
    }

    @GetMapping("/packaging")
    public ResponseResult<List<DiyPackaging>> packaging() {
        return ResponseResult.success(diyPackagingService.list());
    }

    @GetMapping("/works")
    public ResponseResult<List<DiyWorks>> works() {
        Long userId = RequestHolder.getCurrentUserId();
        return ResponseResult.success(diyWorksService.list(
                new LambdaQueryWrapper<DiyWorks>()
                        .eq(DiyWorks::getUserId, userId)
                        .orderByDesc(DiyWorks::getCreateTime)));
    }

    @PostMapping("/works")
    @Transactional
    public ResponseResult<Void> saveWorks(@RequestBody DiyWorksDto dto) {
        Long userId = RequestHolder.getCurrentUserId();
        DiyWorks works = new DiyWorks();
        works.setUserId(userId);
        works.setPackagingId(dto.getPackagingId());
        works.setTotalPrice(dto.getTotalPrice());
        works.setSnapshot(dto.getSnapshot());
        works.setStatus(1);
        diyWorksService.save(works);

        for (DiyWorksDto.WorkItem item : dto.getItems()) {
            DiyWorkItem workItem = new DiyWorkItem();
            workItem.setWorkId(works.getId());
            workItem.setMaterialId(item.getMaterialId());
            workItem.setX(item.getX());
            workItem.setY(item.getY());
            workItem.setScale(item.getScale());
            workItem.setRotation(item.getRotation());
            workItem.setZIndex(item.getZIndex());
            diyWorkItemService.save(workItem);
        }
        return ResponseResult.success();
    }

    @DeleteMapping("/works/{id}")
    public ResponseResult<Void> deleteWorks(@PathVariable Long id) {
        diyWorkItemService.remove(new LambdaQueryWrapper<DiyWorkItem>().eq(DiyWorkItem::getWorkId, id));
        diyWorksService.removeById(id);
        return ResponseResult.success();
    }
}
