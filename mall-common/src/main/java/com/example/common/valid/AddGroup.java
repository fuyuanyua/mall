package com.example.common.valid;

/**
 * @Description: AddGroup
 * 校验分组：
 *      1.说明：对于同一个实体类同一个属性，在不同校验分组下，校验规则不同。
 *      2.实现：
 *          1).实体类属性上注解：
 *          @Null(groups = {AddGroup.class}, message = "品牌id必须为空")
 *          @NotNull(groups = {UpdateGroup.class}, message = "品牌id不能为空")
 *          对于主键id，新增时必须为空，所以指定为AddGroup；更新时必须不为空，所以指定为UpdateGroup。
 *          2).控制层方法要校验的入参上注解：
 *          @RequestBody @Validated(value = {AddGroup.class}) BrandEntity brand
 *          3).若属性没有指定校验分组：
 *          那么在@Validated(value = {AddGroup.class})下这个属性不会被校验，在@Validated下才会被校验。
 * @Author: lhb
 * @Date: 2021/4/15 12:49
 */

public interface AddGroup {
}
