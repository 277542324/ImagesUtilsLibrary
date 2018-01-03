# ImagesUtilsLibrary 特性
#### get方法需传入显示类型
* AnimaRoundAppointImg（动画载入网络圆角图片）
* RoundAppointImg（无动画载入网络圆角图片）
* LocationRoundAppointImg（无动画载入本地圆角图片）
* GlideGifImg（动态gif图片）
* GlideCircleImg（圆形图片）
* AlphaAnima（仿美团点击TAB动画特效）
#### GlideImg方法需传入
* mContext 传入当前Activity
* beginUrl 图片变换前的URL （仅AlphaAnima方法使用，其他方法请填入null）
* endUrl   图片显示的URL （显示图片必须填入此方法的URL，如不填入图片者无法显示）
* resourceId 图片载入前本地图片 （可在drawable、mipmap文件夹下寻找）
* view （显示图片的载体，ImageView）
* RoundNum （图片圆角程度，填入数字0~99）
* type （图片圆角的位置仅AnimaRoundAppointImg、RoundAppointImg、LocationRoundAppointImg有效）
>type
* CornerType.ALL （所有角）
 * CornerType.LEFT_TOP （左上）
* CornerType.LEFT_BOTTOM （左下）
* CornerType.RIGHT_TOP （右上）
* CornerType.RIGHT_BOTTOM （右下）
* CornerType.LEFT （左侧）
* CornerType.RIGHT （右侧）
* CornerType.BOTTOM （下侧）
* CornerType.TOP （上侧）
