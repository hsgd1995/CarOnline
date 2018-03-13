package com.tang.caronline;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;

/**
 * 车辆总览
 * 
 * @author Administrator
 * 
 */
public class CarActivity extends Activity {
	ExpandableListView elCarList;
	/**
	 * 创建车辆总览一级条目容器
	 */
	List<Map<String, String>> carGroups = new ArrayList<Map<String, String>>();
	/**
	 * 车辆总览：存放二级条目, 以便显示在列表中
	 */
	List<List<Map<String, String>>> carChilds = new ArrayList<List<Map<String, String>>>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_car);
		setTitle("车辆总览");
		setDriverListData();
		intiData();
	}

	private void setDriverListData() {
		 // 创建一级条目标题
        Map<String, String> title_1 = new HashMap<String, String>();
        Map<String, String> title_2 = new HashMap<String, String>();
        Map<String, String> title_3 = new HashMap<String, String>();
        title_1.put("group", "可用车辆");
        title_2.put("group", "已用车辆");
        title_3.put("group", "全部车辆");
        carGroups.add(title_1);
        carGroups.add(title_2);
        carGroups.add(title_3);
        // 创建二级条目内容
        // 内容一
        Map<String, String> title_1_content_1_1 = new HashMap<String, String>();
        Map<String, String> title_1_content_1_2 = new HashMap<String, String>();
        title_1_content_1_1.put("child", "可用车辆1");
        title_1_content_1_2.put("child", "可用车辆2");
        title_1_content_1_1.put("child_type", "可用车辆1类型");
        title_1_content_1_2.put("child_type", "可用车辆2类型");
        List<Map<String, String>> childs_1 = new ArrayList<Map<String, String>>();
        childs_1.add(title_1_content_1_1);
        childs_1.add(title_1_content_1_2);

        // 内容二
        Map<String, String> title_2_content_1 = new HashMap<String, String>();
        Map<String, String> title_2_content_2 = new HashMap<String, String>();

        title_2_content_1.put("child", "已用车辆1");
        title_2_content_2.put("child", "已用车辆2");
        title_2_content_1.put("child_type", "已用车辆1类型");
        title_2_content_2.put("child_type", "已用车辆2类型");
        List<Map<String, String>> childs_2 = new ArrayList<Map<String, String>>();
        childs_2.add(title_2_content_1);
        childs_2.add(title_2_content_2);

        
     // 内容三
        Map<String, String> title_3_content_1 = new HashMap<String, String>();
        Map<String, String> title_3_content_2 = new HashMap<String, String>();

        title_3_content_1.put("child", "全部车辆1");
        title_3_content_2.put("child", "全部车辆2");
        title_3_content_1.put("child_type", "全部车辆1类型");
        title_3_content_2.put("child_type", "全部车辆2类型");
        List<Map<String, String>> childs_3 = new ArrayList<Map<String, String>>();
        childs_3.add(title_3_content_1);
        childs_3.add(title_3_content_2);

        
        carChilds.add(childs_1);
        carChilds.add(childs_2);
        carChilds.add(childs_3);
	}

	private void intiData() {
		elCarList = (ExpandableListView) findViewById(R.id.el_carList);
		elCarList.setAdapter(new SimpleExpandableListAdapter(
				this, carGroups, R.layout.activity_car_groups, new String[] {"group"}, 
				new int[]{R.id.carList_groups}, carChilds, R.layout.activity_car_childs,
				new String[]{"child","child_type"}, new int[]{R.id.carlist_childs_name,R.id.carlist_childs_type}));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.car, menu);
		return true;
	}

}
