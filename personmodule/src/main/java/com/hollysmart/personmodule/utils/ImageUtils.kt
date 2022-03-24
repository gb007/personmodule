package com.hollysmart.personmodule.utils

import android.content.Context
import android.graphics.Color
import android.net.Uri
import android.os.Environment
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.drawee.generic.GenericDraweeHierarchy
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder
import com.facebook.drawee.generic.RoundingParams
import com.facebook.drawee.interfaces.DraweeController
import com.facebook.drawee.view.SimpleDraweeView
import java.io.File


/**
 * @author: created by JiangNan
 * @Date: 2020/4/2 19
 */
object ImageUtils {
    /**
     * 加载圆角图片
     *
     * @param image
     * @param imageUrl
     */
    fun setRoundImage(context: Context, image: SimpleDraweeView, imageUrl: String?) {
        /**初始化圆角圆形参数对象 */
        val rp = RoundingParams()
        /**设置图像是否为圆形 */
        rp.roundAsCircle = true
        /**设置边框颜色及其宽度 */
        rp.setBorder(Color.WHITE, 2f)
        /**设置叠加颜色 */
        rp.overlayColor = Color.GRAY
        /**设置圆形圆角模式 */
        rp.roundingMethod = RoundingParams.RoundingMethod.OVERLAY_COLOR
        /**获取GenericDraweeHierarchy对象 */
        val hierarchy = GenericDraweeHierarchyBuilder.newInstance(context.resources)
            /**设置圆形圆角参数 */
            .setRoundingParams(rp)
            .setRoundingParams(RoundingParams.asCircle())
            /**设置淡入淡出动画持续时间(单位：毫秒ms) */
            .setFadeDuration(1000)
            .build()
        image.hierarchy = hierarchy
        /**构建Controller */
        val controller: DraweeController = Fresco.newDraweeControllerBuilder().setUri(imageUrl)
            /**设置需要下载的图片地址 */
            /**设置点击重试是否开启 */
            .setTapToRetryEnabled(true)
            .build()
        /**设置Controller */
        image.controller = controller
    }

    fun getImageStreamFromExternal(imageName: String?): Uri? {
        val externalPubPath = Environment.getExternalStoragePublicDirectory(
            Environment.DIRECTORY_PICTURES
        )
        val picPath = File(externalPubPath, imageName)
        var uri: Uri? = null
        if (picPath.exists()) {
            uri = Uri.fromFile(picPath)
        }
        return uri
    }


    fun getImageStreamFromInternal(path: String?): Uri? {
//        val externalPubPath = Environment.getExternalStoragePublicDirectory(
//            Environment.DIRECTORY_PICTURES
//        )
        val picPath = File(path)
        var uri: Uri? = null
        if (picPath.exists()) {
            uri = Uri.fromFile(picPath)
        }
        return uri
    }

}