package com.tang.caronline;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import android.annotation.TargetApi;
import android.app.ExpandableListActivity;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;
import android.widget.Toast;

public class CarSettingActivity extends ExpandableListActivity {
	
	private View CView;
	 /**
     * 创建一级条目容器
     */
    List<Map<String, String>> gruops = new ArrayList<Map<String, String>>();
    /**
     * 存放内容, 以便显示在列表中
     */
    List<List<Map<String, String>>> childs = new ArrayList<List<Map<String, String>>>();
    @Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.car_setting);
		setListData();
	}


	/**
     * 设置列表内容
     */
    public void setListData() {
        // 创建二个一级条目标题
        Map<String, String> title_1 = new HashMap<String, String>();
        Map<String, String> title_2 = new HashMap<String, String>();
        Map<String, String> title_3 = new HashMap<String, String>();
        title_1.put("group", "林炳文");
        title_2.put("group", "文炳林");
        gruops.add(title_1);
        gruops.add(title_2);
 
        // 创建二级条目内容
        // 内容一
        Map<String, String> title_1_content_1 = new HashMap<String, String>();
        Map<String, String> title_1_content_2 = new HashMap<String, String>();
        Map<String, String> title_1_content_3 = new HashMap<String, String>();
        title_1_content_1.put("child", "工人");
        title_1_content_2.put("child", "学生");
        title_1_content_3.put("child", "农民");
 
        List<Map<String, String>> childs_1 = new ArrayList<Map<String, String>>();
        childs_1.add(title_1_content_1);
        childs_1.add(title_1_content_2);
        childs_1.add(title_1_content_3);
 
        // 内容二
        Map<String, String> title_2_content_1 = new HashMap<String, String>();
        Map<String, String> title_2_content_2 = new HashMap<String, String>();
        Map<String, String> title_2_content_3 = new HashMap<String, String>();
        title_2_content_1.put("child", "猩猩");
        title_2_content_2.put("child", "老虎");
        title_2_content_3.put("child", "狮子");
        List<Map<String, String>> childs_2 = new ArrayList<Map<String, String>>();
        childs_2.add(title_2_content_1);
        childs_2.add(title_2_content_2);
        childs_2.add(title_2_content_3);
 
        childs.add(childs_1);
        childs.add(childs_2);
 
        /**
         * 创建ExpandableList的Adapter容器 参数: 1.上下文 2.一级集合 3.一级样式文件 4. 一级条目键值
         * 5.一级显示控件名 6. 二级集合 7. 二级样式 8.二级条目键值 9.二级显示控件名
         * 
         */
        SimpleExpandableListAdapter sela = new SimpleExpandableListAdapter(
                this, gruops, R.layout.car_setting_groups, new String[] { "group" },
                new int[] { R.id.carSetting_groups }, childs, R.layout.car_setting_childs,
                new String[] { "child" }, new int[] { R.id.carSetting_childs });
        // 加入列表
        setListAdapter(sela);
    }
 
    /**
     * 列表内容按下
     */
    @Override
    public boolean onChildClick(ExpandableListView parent, View v,
            int groupPosition, int childPosition, long id) {
        Toast.makeText( CarSettingActivity.this,"您选择了"+ gruops.get(groupPosition).toString()+ "子编号"+ childs.get(groupPosition).get(childPosition)
                                .toString(), Toast.LENGTH_SHORT).show();
        return super.onChildClick(parent, v, groupPosition, childPosition, id);
    }
 
    /**
     * 二级标题按下
     */
    @Override
    public boolean setSelectedChild(int groupPosition, int childPosition,
            boolean shouldExpandGroup) {
        return super.setSelectedChild(groupPosition, childPosition,
                shouldExpandGroup);
    }
 
    /**
     * 一级标题按下
     */
    @Override
    public void setSelectedGroup(int groupPosition) {
        super.setSelectedGroup(groupPosition);
    }

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.car_setting, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
