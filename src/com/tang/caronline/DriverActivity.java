package com.tang.caronline;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ExpandableListView;
import android.widget.SimpleAdapter;
import android.widget.SimpleExpandableListAdapter;
/**
 * 驾驶员总览
 * @author Administrator
 *
 */
public class DriverActivity extends Activity {
	ExpandableListView elDriverList;
	/**
     * 创建驾驶员总览一级条目容器
     */
    List<Map<String, String>> driverGroups = new ArrayList<Map<String, String>>();
    /**
     * 驾驶员总览：存放二级条目, 以便显示在列表中
     */
    List<List<Map<String, String>>> driverChilds = new ArrayList<List<Map<String, String>>>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_driver);
		setDriverListData();
		intiData();
	}
	
	
	private void intiData() {
		elDriverList = (ExpandableListView) findViewById(R.id.el_driverList);
		elDriverList.setAdapter(new SimpleExpandableListAdapter(
				this, driverGroups, R.layout.activity_driver_groups, new String[] {"group"}, 
				new int[]{R.id.driverList_groups}, driverChilds, R.layout.activity_driver_childs,
				new String[]{"child","child_licence"}, new int[]{R.id.driverlist_childs_name,R.id.driverlist_childs_licence}));
	}

	public void setDriverListData(){
		 // 创建一级条目标题
        Map<String, String> title_1 = new HashMap<String, String>();
        Map<String, String> title_2 = new HashMap<String, String>();
        Map<String, String> title_3 = new HashMap<String, String>();
        title_1.put("group", "可用司机");
        title_2.put("group", "已用司机");
        title_3.put("group", "全部司机");
        driverGroups.add(title_1);
        driverGroups.add(title_2);
        driverGroups.add(title_3);
        // 创建二级条目内容
        // 内容一
        Map<String, String> title_1_content_1_1 = new HashMap<String, String>();
        Map<String, String> title_1_content_1_2 = new HashMap<String, String>();
        title_1_content_1_1.put("child", "可用司机1");
        title_1_content_1_2.put("child", "可用司机2");
        title_1_content_1_1.put("child_licence", "可用司机1执照");
        title_1_content_1_2.put("child_licence", "可用司机2执照");
        List<Map<String, String>> childs_1 = new ArrayList<Map<String, String>>();
        childs_1.add(title_1_content_1_1);
        childs_1.add(title_1_content_1_2);

        // 内容二
        Map<String, String> title_2_content_1 = new HashMap<String, String>();
        Map<String, String> title_2_content_2 = new HashMap<String, String>();

        title_2_content_1.put("child", "已用司机1");
        title_2_content_2.put("child", "已用司机2");
        title_2_content_1.put("child_licence", "已用司机1执照");
        title_2_content_2.put("child_licence", "已用司机2执照");
        List<Map<String, String>> childs_2 = new ArrayList<Map<String, String>>();
        childs_2.add(title_2_content_1);
        childs_2.add(title_2_content_2);

        
     // 内容三
        Map<String, String> title_3_content_1 = new HashMap<String, String>();
        Map<String, String> title_3_content_2 = new HashMap<String, String>();

        title_3_content_1.put("child", "全部司机1");
        title_3_content_2.put("child", "全部司机2");
        title_3_content_1.put("child_licence", "全部司机1执照");
        title_3_content_2.put("child_licence", "全部司机2执照");
        List<Map<String, String>> childs_3 = new ArrayList<Map<String, String>>();
        childs_3.add(title_3_content_1);
        childs_3.add(title_3_content_2);

        
        driverChilds.add(childs_1);
        driverChilds.add(childs_2);
        driverChilds.add(childs_3);
        
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.driver, menu);
		return true;
	}

}
