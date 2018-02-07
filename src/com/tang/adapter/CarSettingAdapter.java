package com.tang.adapter;

import java.util.List;
import java.util.Map;

import android.content.Context;
import android.widget.SimpleExpandableListAdapter;

public class CarSettingAdapter  extends SimpleExpandableListAdapter{

	public CarSettingAdapter(Context context,
			List<? extends Map<String, ?>> groupData, int expandedGroupLayout,
			int collapsedGroupLayout, String[] groupFrom, int[] groupTo,
			List<? extends List<? extends Map<String, ?>>> childData,
			int childLayout, int lastChildLayout, String[] childFrom,
			int[] childTo) {
		super(context, groupData, expandedGroupLayout, collapsedGroupLayout, groupFrom,
				groupTo, childData, childLayout, lastChildLayout, childFrom, childTo);
		// TODO Auto-generated constructor stub
	}

	

}
