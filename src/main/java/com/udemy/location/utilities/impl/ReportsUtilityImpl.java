package com.udemy.location.utilities.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.stereotype.Component;

import com.udemy.location.utilities.ReportsUtility;

@Component
public class ReportsUtilityImpl implements ReportsUtility {

	@Override
	public void generateReport(String path, List<Object[]> data) {
		DefaultPieDataset dataset = new DefaultPieDataset();
	    for (Object[] object : data) {
             
	    	dataset.setValue(object[0].toString(), new Double(object[1].toString()));
		}
		
		JFreeChart chart = ChartFactory.createPieChart3D("Location Type Repots", dataset, false, false, false);
		try {
			ChartUtilities.saveChartAsJPEG(new File(path+"/report.jpeg"), chart, 500, 200);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
