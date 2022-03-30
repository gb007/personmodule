# personInfomodule模块使用说明

## 1.在工程的根目录build.gradle中添加jitpack库依赖

````

allprojects {
		repositories {
			...
			maven { url 'https://www.jitpack.io' }
		}
	}
	
````

## 2.在需要引用此类库模块的build.gradle中引入依赖

 ````
dependencies {
	implementation 'com.github.gb007:personmodule:Tag'
	}

````

## 3.初始化个人信息模块配置信息，加载个人信息Fragment

````

 //个人信息模块配置
        var personConfig = PersonConfig()
        //用户姓名
        personConfig.userName = "张shanshan"
        //用户部门
        personConfig.department = "信息化技术运营保障中心"
        //用户头像url
        personConfig.headviewUrl =
            "https://img0.baidu.com/it/u=859314309,692804921&fm=253&fmt=auto&app=138&f=JPEG?w=400&h=400"
        //是否展示收藏功能
        personConfig.showFavor = View.VISIBLE
        //是否展示分享功能
        personConfig.showShare = View.VISIBLE
        //是否展示扫一扫功能
        personConfig.showScan = View.VISIBLE
        //是否展示设置功能
        personConfig.showSetting = View.VISIBLE
        //是否展示意见反馈功能
        personConfig.showFeed = View.VISIBLE
        //是否展示关于我们功能
        personConfig.showAbout = View.VISIBLE

        //隐私政策名称
        personConfig.privacyTitle = "杨柳飞絮防治隐私政策"
        //服务协议名称
        personConfig.serviceTitle = "杨柳飞絮防治服务"
        //隐私政策内容url
        personConfig.privacyUrl = "https://qnimg.daolan.com.cn/yangliufeixufangzhiyinsizhengce.html"
        //服务协议内容url
        personConfig.serviceUrl = "https://qnimg.daolan.com.cn/yangliufeixufuwuxieyi.html"
        //版权所有
        personConfig.copyright = "北京市机关事务管理局  版权所有"
        //版权号
        personConfig.coptright_code = "Copyright \\u00a9 2019-2020 All Rights Reserved"


        var personInfoFragment = PersonInfoFragment()
        personInfoFragment.personConfig = personConfig
        supportFragmentManager //
            .beginTransaction()
            .add(
                R.id.fragment_container,
                personInfoFragment
            ) // 此处的R.id.fragment_container是要盛放fragment的父容器
            .commit()

````

