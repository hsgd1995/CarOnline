package com.tang.caronline;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tang.activity.LoginActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ExpandableListView;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.SimpleExpandableListAdapter;

public class MainActivity extends Activity {
	private ViewPager viewPager;
	private RadioGroup radioGroup;
	private List<View> viewList;
	ExpandableListView elCarSetting;
	ExpandableListView elSysSetting;
	ExpandableListView elMySetting;
	/**
     * 创建车辆管理一级条目容器
     */
    List<Map<String, String>> carSettingGroups = new ArrayList<Map<String, String>>();
    /**
     * 车辆管理：存放二级条目, 以便显示在列表中
     */
    List<List<Map<String, String>>> carSettingchilds = new ArrayList<List<Map<String, String>>>();
    
    /**
     * 创建系统管理一级条目容器
     */
    List<Map<String, String>> sysSettingGroups = new ArrayList<Map<String, String>>();
    /**
     * 系统管理：存放二级条目
     */
    List<List<Map<String,String>>> sysSettingChilds = new ArrayList<List<Map<String,String>>>();
    /**
     * 创建我的管理一级条目容器
     */
    List<Map<String,String>> mySettingGroups = new ArrayList<Map<String,String>>();
    /**
     * 我的管理：存放二级条目
     */
    List<List<Map<String,String>>> mySettingChilds = new ArrayList<List<Map<String,String>>>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		
		initView();
		setCarSettingListData();
		setSysSettingListData();
		setMySettingListData();
		initData();
		initEvent();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	

	/**
	 * 初始化视图
	 */
	public void initView() {
		viewPager = (ViewPager) findViewById(R.id.viewPager);
		radioGroup = (RadioGroup) findViewById(R.id.radioGroup);

	}
	
	
	/**
	 * 初始化数据
	 */
	public void initData() {
		viewList = new ArrayList<View>();
		LayoutInflater inflater = LayoutInflater.from(this);
		View carControl = inflater.inflate(R.layout.car_control, null);
		View carSetting = inflater.inflate(R.layout.car_setting, null);
		View sysSetting = inflater.inflate(R.layout.system_setting, null);
		View mySetting = inflater.inflate(R.layout.my_setting, null);
		viewList.add(carControl);
		viewList.add(carSetting);
		viewList.add(sysSetting);
		viewList.add(mySetting);
		viewPager.setAdapter(new PagerAdapter() {

			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return viewList.size();
			}

			@Override
			public boolean isViewFromObject(View arg0, Object arg1) {
				// TODO Auto-generated method stub
				return arg0==arg1;
			}
			
			@Override
			public void destroyItem(ViewGroup container, int position,
					Object object) {
				container.removeView(viewList.get(position));
			}
			@Override
			public Object instantiateItem(ViewGroup container, int position) {
				View view = viewList.get(position);
				container.addView(view);
				return view;
			}
		});
		
		elCarSetting = (ExpandableListView) carSetting.findViewById(R.id.el_carS);
		elCarSetting.setAdapter(new SimpleExpandableListAdapter(
                this, carSettingGroups, R.layout.car_setting_groups, new String[] { "group" },
                new int[] { R.id.carSetting_groups }, carSettingchilds, R.layout.car_setting_childs,
                new String[] { "child" }, new int[] { R.id.carSetting_childs }) );
		
		elSysSetting = (ExpandableListView) sysSetting.findViewById(R.id.el_sysSetting);
		elSysSetting.setAdapter(new SimpleExpandableListAdapter(
				this, sysSettingGroups, R.layout.sys_setting_groups, new String[] {"group"}, 
				new int[]{R.id.sysSetting_groups}, sysSettingChilds, R.layout.sys_setting_childs,
				new String[]{"child"}, new int[]{R.id.sysSetting_childs}));
		
		elMySetting = (ExpandableListView) mySetting.findViewById(R.id.el_myS);
		elMySetting.setAdapter(new SimpleExpandableListAdapter(
				this, mySettingGroups, R.layout.my_setting_groups, new String[] {"group"},
				new int[]{R.id.mySetting_groups}, mySettingChilds, R.layout.my_setting_childs,
				new String[] {"child"}, new int[]{R.id.mySetting_childs}));
		
	}
	
	/**
     * 设置车辆管理列表内容
     */
    public void setCarSettingListData() {
        // 创建一级条目标题
        Map<String, String> title_1 = new HashMap<String, String>();
        Map<String, String> title_2 = new HashMap<String, String>();
        Map<String, String> title_3 = new HashMap<String, String>();
        Map<String, String> title_4 = new HashMap<String, String>();
        Map<String, String> title_5 = new HashMap<String, String>();
        title_1.put("group", "系统设置");
        title_2.put("group", "基础数据管理");
        title_3.put("group", "用车流程管理");
        title_4.put("group", "费用管理");
        title_5.put("group", "日志管理");
        carSettingGroups.add(title_1);
        carSettingGroups.add(title_2);
        carSettingGroups.add(title_3);
        carSettingGroups.add(title_4);
        carSettingGroups.add(title_5);
 
        // 创建二级条目内容
        // 内容一
        Map<String, String> title_1_content_1 = new HashMap<String, String>();
        Map<String, String> title_1_content_2 = new HashMap<String, String>();
        Map<String, String> title_1_content_3 = new HashMap<String, String>();
        Map<String, String> title_1_content_4 = new HashMap<String, String>();
        title_1_content_1.put("child", "单位管理");
        title_1_content_2.put("child", "部门管理");
        title_1_content_3.put("child", "角色管理");
        title_1_content_4.put("child", "用户管理");
 
        List<Map<String, String>> childs_1 = new ArrayList<Map<String, String>>();
        childs_1.add(title_1_content_1);
        childs_1.add(title_1_content_2);
        childs_1.add(title_1_content_3);
        childs_1.add(title_1_content_4);
 
        // 内容二
        Map<String, String> title_2_content_1 = new HashMap<String, String>();
        Map<String, String> title_2_content_2 = new HashMap<String, String>();
        title_2_content_1.put("child", "车辆管理");
        title_2_content_2.put("child", "驾驶员管理");
        List<Map<String, String>> childs_2 = new ArrayList<Map<String, String>>();
        childs_2.add(title_2_content_1);
        childs_2.add(title_2_content_2);
     // 内容三
        Map<String, String> title_3_content_1 = new HashMap<String, String>();
        Map<String, String> title_3_content_2 = new HashMap<String, String>();
        Map<String, String> title_3_content_3 = new HashMap<String, String>();
        Map<String, String> title_3_content_4 = new HashMap<String, String>();
        Map<String, String> title_3_content_5 = new HashMap<String, String>();
        Map<String, String> title_3_content_6 = new HashMap<String, String>();
        Map<String, String> title_3_content_7 = new HashMap<String, String>();
        Map<String, String> title_3_content_8 = new HashMap<String, String>();
        Map<String, String> title_3_content_9 = new HashMap<String, String>();
        Map<String, String> title_3_content_10 = new HashMap<String, String>();
        Map<String, String> title_3_content_11 = new HashMap<String, String>();
        Map<String, String> title_3_content_12 = new HashMap<String, String>();
        Map<String, String> title_3_content_13 = new HashMap<String, String>();
        Map<String, String> title_3_content_14 = new HashMap<String, String>();
        Map<String, String> title_3_content_15 = new HashMap<String, String>();
        Map<String, String> title_3_content_16 = new HashMap<String, String>();
        Map<String, String> title_3_content_17 = new HashMap<String, String>();
        Map<String, String> title_3_content_18 = new HashMap<String, String>();
        Map<String, String> title_3_content_19 = new HashMap<String, String>();
        Map<String, String> title_3_content_20 = new HashMap<String, String>();
        title_3_content_1.put("child", "车辆总览");
        title_3_content_2.put("child", "警报总览");
        title_3_content_3.put("child", "警报列表");
        title_3_content_4.put("child", "驾驶员总览");
        title_3_content_5.put("child", "警报总览-两办");
        title_3_content_6.put("child", "驾驶员月出车天数");
        title_3_content_7.put("child", "月危险驾驶行为总览");
        title_3_content_8.put("child", "驾驶员排班");
        title_3_content_9.put("child", "驾驶员请假");
        title_3_content_10.put("child", "用车申请");
        title_3_content_11.put("child", "用车历史");
        title_3_content_12.put("child", "用车单位领导审批");
        title_3_content_13.put("child", "机关事务局领导审批");
        title_3_content_14.put("child", "区委办/区政府办审批");
        title_3_content_15.put("child", "用车调度");
        title_3_content_16.put("child", "结束用车");
        title_3_content_17.put("child", "归还车辆");
        title_3_content_18.put("child", "用车评价");
        title_3_content_19.put("child", "确认还车");
        title_3_content_20.put("child", "用车查询");
        List<Map<String, String>> childs_3 = new ArrayList<Map<String, String>>();
        childs_3.add(title_3_content_1);
        childs_3.add(title_3_content_2);
        childs_3.add(title_3_content_3);
        childs_3.add(title_3_content_4);
        childs_3.add(title_3_content_5);
        childs_3.add(title_3_content_6);
        childs_3.add(title_3_content_7);
        childs_3.add(title_3_content_8);
        childs_3.add(title_3_content_9);
        childs_3.add(title_3_content_10);
        childs_3.add(title_3_content_11);
        childs_3.add(title_3_content_12);
        childs_3.add(title_3_content_13);
        childs_3.add(title_3_content_14);
        childs_3.add(title_3_content_15);
        childs_3.add(title_3_content_16);
        childs_3.add(title_3_content_17);
        childs_3.add(title_3_content_18);
        childs_3.add(title_3_content_19);
        childs_3.add(title_3_content_20);
        
        //内容四
        Map<String, String> title_4_content_1 = new HashMap<String, String>();
        Map<String, String> title_4_content_2 = new HashMap<String, String>();
        Map<String, String> title_4_content_3 = new HashMap<String, String>();
        Map<String, String> title_4_content_4 = new HashMap<String, String>();
        Map<String, String> title_4_content_5 = new HashMap<String, String>();
        Map<String, String> title_4_content_6 = new HashMap<String, String>();
        Map<String, String> title_4_content_7 = new HashMap<String, String>();
        Map<String, String> title_4_content_8 = new HashMap<String, String>();
        Map<String, String> title_4_content_9 = new HashMap<String, String>();
        Map<String, String> title_4_content_10 = new HashMap<String, String>();
        Map<String, String> title_4_content_11 = new HashMap<String, String>();
        Map<String, String> title_4_content_12 = new HashMap<String, String>();
        Map<String, String> title_4_content_13 = new HashMap<String, String>();
        Map<String, String> title_4_content_14 = new HashMap<String, String>();
        Map<String, String> title_4_content_15 = new HashMap<String, String>();
        Map<String, String> title_4_content_16 = new HashMap<String, String>();
        Map<String, String> title_4_content_17 = new HashMap<String, String>();
        Map<String, String> title_4_content_18 = new HashMap<String, String>();
        title_4_content_1.put("child", "月支出统计表");
        title_4_content_2.put("child", "车辆明细");
        title_4_content_3.put("child", "费用总览表");
        title_4_content_4.put("child", "油费一览表");
        title_4_content_5.put("child", "维保一览表");
        title_4_content_6.put("child", "年审一览表");
        title_4_content_7.put("child", "保险一览表");
        title_4_content_8.put("child", "加油历史");
        title_4_content_9.put("child", "油费审批");
        title_4_content_10.put("child", "维保历史");
        title_4_content_11.put("child", "洗车申请");
        title_4_content_12.put("child", "更换机油申请");
        title_4_content_13.put("child", "维保验收人审批");
        title_4_content_14.put("child", "维保负责人审批");
        title_4_content_15.put("child", "保险历史");
        title_4_content_16.put("child", "保险审批");
        title_4_content_17.put("child", "年审历史");
        title_4_content_18.put("child", "年审审批");

        List<Map<String, String>> childs_4 = new ArrayList<Map<String, String>>();
        childs_4.add(title_4_content_1);
        childs_4.add(title_4_content_2);
        childs_4.add(title_4_content_3);
        childs_4.add(title_4_content_4);
        childs_4.add(title_4_content_5);
        childs_4.add(title_4_content_6);
        childs_4.add(title_4_content_7);
        childs_4.add(title_4_content_8);
        childs_4.add(title_4_content_9);
        childs_4.add(title_4_content_10);
        childs_4.add(title_4_content_11);
        childs_4.add(title_4_content_12);
        childs_4.add(title_4_content_13);
        childs_4.add(title_4_content_14);
        childs_4.add(title_4_content_15);
        childs_4.add(title_4_content_16);
        childs_4.add(title_4_content_17);
        childs_4.add(title_4_content_18);
        //内容五        
        Map<String, String> title_5_content_1 = new HashMap<String, String>();
        title_5_content_1.put("child", "用户操作日志");
        List<Map<String, String>> childs_5 = new ArrayList<Map<String,String>>();
        childs_5.add(title_5_content_1);
        
        carSettingchilds.add(childs_1);
        carSettingchilds.add(childs_2);
        carSettingchilds.add(childs_3);
        carSettingchilds.add(childs_4);
        carSettingchilds.add(childs_5);
        /**
         * 创建ExpandableList的Adapter容器 参数: 1.上下文 2.一级集合 3.一级样式文件 4. 一级条目键值
         * 5.一级显示控件名 6. 二级集合 7. 二级样式 8.二级条目键值 9.二级显示控件名
         * 
         */
         /*sela = new SimpleExpandableListAdapter(
                this, gruops, R.layout.car_setting_groups, new String[] { "group" },
                new int[] { R.id.carSetting_groups }, childs, R.layout.car_setting_childs,
                new String[] { "child" }, new int[] { R.id.carSetting_childs });*/
        // 加入列表
        //setListAdapter(sela);
    }
	
    /**
     * 设置系统管理列表内容
     */
    public void setSysSettingListData(){
    	//创建一级条目
    	Map<String, String> title_1 = new HashMap<String, String>();
    	Map<String, String> title_2 = new HashMap<String, String>();
    	title_1.put("group", "系统设置");
    	title_2.put("group", "车辆管理");
    	sysSettingGroups.add(title_1);
    	sysSettingGroups.add(title_2);
    	//创建二级条目
    	Map<String, String> title_1_content1 = new HashMap<String, String>();
    	Map<String, String> title_1_content2 = new HashMap<String, String>();
    	Map<String, String> title_1_content3 = new HashMap<String, String>();
    	Map<String, String> title_1_content4 = new HashMap<String, String>();
    	title_1_content1.put("child", "单位管理");
    	title_1_content2.put("child", "部门管理");
    	title_1_content3.put("child", "角色管理");
    	title_1_content4.put("child", "用户管理");
    	List<Map<String, String>> childs_1 = new ArrayList<Map<String,String>>();
    	childs_1.add(title_1_content1);
    	childs_1.add(title_1_content2);
    	childs_1.add(title_1_content3);
    	childs_1.add(title_1_content4);
    	
    	Map<String, String> title_2_content1 = new HashMap<String, String>();
    	Map<String, String> title_2_content2 = new HashMap<String, String>();
    	title_2_content1.put("child", "驾驶员管理");
    	title_2_content2.put("child", "车辆管理");
    	List<Map<String, String>> childs_2 = new ArrayList<Map<String,String>>();
    	childs_2.add(title_2_content1);
    	childs_2.add(title_2_content2);
    	
    	sysSettingChilds.add(childs_1);
    	sysSettingChilds.add(childs_2);
    }
    /**
     * 设置我的管理列表内容
     */
    public void setMySettingListData(){
    	Map<String, String> title_1 = new HashMap<String, String>();
    	Map<String, String> title_2 = new HashMap<String, String>();
    	title_1.put("group", "我的");
    	title_2.put("group", "系统");
    	mySettingGroups.add(title_1);
    	mySettingGroups.add(title_2);
    	
    	Map<String, String> title_1_content_1 = new HashMap<String, String>();
    	title_1_content_1.put("child", "修改信息");
    	List<Map<String, String>> childs_1 = new ArrayList<Map<String,String>>();
    	childs_1.add(title_1_content_1);
    	
    	Map<String, String> title_2_content_1 = new HashMap<String, String>();
    	title_2_content_1.put("child", "退出系统");
    	List<Map<String, String>> childs_2 = new ArrayList<Map<String,String>>();
    	childs_2.add(title_2_content_1);
    	
    	mySettingChilds.add(childs_1);
    	mySettingChilds.add(childs_2);
    	
    	
    }
	/**
	 * 
	 * <p>
	 * Title:初始化事件
	 * </p>
	 * <p>
	 * Description: 为界面上的组件添加事件
	 * </p>
	 * 
	 * @author TSK
	 * @param null return: void
	 * @date 下午3:01:35
	 */
	public void initEvent() {
		viewPager.setOnPageChangeListener(new OnPageChangeListener() {

			/**
			 * 当页面状态发生改变时调用
			 */
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub

			}

			/**
			 * 当页面发生滑动时被调用
			 */
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub

			}

			/**
			 * 当页面被选中时候调用
			 */
			@Override
			public void onPageSelected(int arg0) {
				switch (arg0) {
				case 0:
					radioGroup.check(R.id.car_control);
					break;
				case 1:
					radioGroup.check(R.id.car_setting);
					break;
				case 2:
					radioGroup.check(R.id.sys_setting);
					break;
				case 3:
					radioGroup.check(R.id.my_setting);
					break;
				}
			}
		});
		// 绑定单选框选中事件
		radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			// 按钮被点击
			@Override
			public void onCheckedChanged(RadioGroup arg0, int checkedId) {
				switch (checkedId) {
				case R.id.car_control:
					viewPager.setCurrentItem(0);
					break;

				case R.id.car_setting:
					viewPager.setCurrentItem(1);
					/*Intent intent = new Intent(MainActivity.this, CarSettingActivity.class);
					startActivity(intent);
					finish();*/
					break;

				case R.id.sys_setting:
					viewPager.setCurrentItem(2);
					break;

				case R.id.my_setting:
					viewPager.setCurrentItem(3);
					break;

				}
			}
		});
		
		radioGroup.check(R.id.car_control);

	}
	@Override
	protected void onResume() {

		super.onResume();
	}
}



