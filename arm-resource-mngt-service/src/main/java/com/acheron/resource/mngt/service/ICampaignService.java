package com.acheron.resource.mngt.service;

import java.sql.Timestamp;
import java.util.List;

import com.acheron.resource.mngt.entity.Campaign;
import com.acheron.resource.mngt.exception.CampaignNotFoundException;
import com.acheron.resource.mngt.exception.IDNotFoundException;

public interface ICampaignService {

	public List<Campaign> getAllCampaign() throws CampaignNotFoundException;

	public void createCampaign(Campaign campaign);

	public Campaign getById(int l) throws IDNotFoundException;
	
	List<Campaign> getAllResourcesCampaignDetails() throws CampaignNotFoundException;
	
	public Campaign addCampaign(Campaign campaign);
	
	List<Campaign> getCamapignOfMonth(Timestamp startDate, Timestamp endDate);
}
