package com.technical.evaluation.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import com.technical.evaluation.domain.UserCreditCheck;

import weka.classifiers.trees.J48;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

@Component
public class CreditRepository {
	
	@Value("${weka.instance.index.check}")
	private Integer indexCheck; 
	
	@Autowired
    private ResourceLoader resourceLoader;
	
	public Instances getInstaces() throws Exception {
		return getInstaces("classpath:data.arff");
	}
	
	protected Instances getInstaces(String pathFile) throws Exception {
		Resource resource = resourceLoader.getResource(pathFile);
		DataSource ds = new DataSource(resource.getInputStream());
		Instances instances = ds.getDataSet();
		instances.setClassIndex(indexCheck);		
		return instances;
	}

	public List<Double> getAnalyze(UserCreditCheck user) throws Exception {
		J48 j48 = new J48();
		j48.buildClassifier(getInstaces());
		
		Instance instanceUser = new DenseInstance(indexCheck+1);
		instanceUser.setDataset(getInstaces());
		instanceUser.setValue(0, user.getYearsOld());
		instanceUser.setValue(1, user.getGender());
		instanceUser.setValue(2, user.getStatus());
		instanceUser.setValue(3, user.getDependent());
		instanceUser.setValue(4, user.getIncome());
		return getList(j48.distributionForInstance(instanceUser));
	}
	
	private List<Double> getList(double [] array) {
		List<Double> list = new ArrayList<>();
		for(int i=0; i< array.length; i++) {
			list.add(new Double(array[i]));
		}
		return list;
	}
	
}
