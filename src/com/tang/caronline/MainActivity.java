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
	ExpandableListView ex;
	/**
     * 创建一级条目容器
     */
    List<Map<String, String>> gruops = new ArrayList<Map<String, String>>();
    /**
     * 存放内容, 以便显示在列表中
     */
    List<List<Map<String, String>>> childs = new ArrayList<List<Map<String, String>>>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		
		initView();
		setListData();
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
		
		ex = (ExpandableListView) carSetting.findViewById(R.id.el_carS);
		
		ex.setAdapter(new SimpleExpandableListAdapter(
                this, gruops, R.layout.car_setting_groups, new String[] { "group" },
                new int[] { R.id.carSetting_groups }, childs, R.layout.car_setting_childs,
                new String[] { "child" }, new int[] { R.id.carSetting_childs }) );
	}
	
	/**
     * 设置列表内容
     */
    public void setListData() {
        // 创建二个一级条目标题
        Map<String, String> title_1 = new HashMap<String, String>();
        Map<String, String> title_2 = new HashMap<String, String>();
        Map<String, String> title_3 = new HashMap<String, String>();
        title_1.put("group", "text1");
        title_2.put("group", "text2");
        title_3.put("group", "text3");
        gruops.add(title_1);
        gruops.add(title_2);
        gruops.add(title_3);
 
        // 创建二级条目内容
        // 内容一
        Map<String, String> title_1_content_1 = new HashMap<String, String>();
        Map<String, String> title_1_content_2 = new HashMap<String, String>();
        Map<String, String> title_1_content_3 = new HashMap<String, String>();
        title_1_content_1.put("child", "测试1_1");
        title_1_content_2.put("child", "测试1_2");
        title_1_content_3.put("child", "测试1_3");
 
        List<Map<String, String>> childs_1 = new ArrayList<Map<String, String>>();
        childs_1.add(title_1_content_1);
        childs_1.add(title_1_content_2);
        childs_1.add(title_1_content_3);
 
        // 内容二
        Map<String, String> title_2_content_1 = new HashMap<String, String>();
        Map<String, String> title_2_content_2 = new HashMap<String, String>();
        Map<String, String> title_2_content_3 = new HashMap<String, String>();
        title_2_content_1.put("child", "测试2_1");
        title_2_content_2.put("child", "测试2_2");
        title_2_content_3.put("child", "测试2_3");
        List<Map<String, String>> childs_2 = new ArrayList<Map<String, String>>();
        childs_2.add(title_2_content_1);
        childs_2.add(title_2_content_2);
        childs_2.add(title_2_content_3);
     // 内容三
        Map<String, String> title_3_content_1 = new HashMap<String, String>();
        Map<String, String> title_3_content_2 = new HashMap<String, String>();
        Map<String, String> title_3_content_3 = new HashMap<String, String>();
        title_3_content_1.put("child", "测试3_1");
        title_3_content_2.put("child", "测试3_2");
        title_3_content_3.put("child", "测试3_3");
        List<Map<String, String>> childs_3 = new ArrayList<Map<String, String>>();
        childs_3.add(title_3_content_1);
        childs_3.add(title_3_content_2);
        childs_3.add(title_3_content_3);
 
        childs.add(childs_1);
        childs.add(childs_2);
        childs.add(childs_3);
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



