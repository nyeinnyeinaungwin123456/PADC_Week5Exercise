package com.anastatia.testing.data.agents.model;

import com.anastatia.testing.data.vos.AttractionVO;
import com.anastatia.testing.utils.CommonInstances;
import com.anastatia.testing.utils.JsonUtils;
import com.anastatia.testing.utils.MyanmarAttractionsConstants;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Nyein Nyein on 7/18/2016.
 */
public class AttractionModel {

    public List<AttractionVO> attractionVOList;
    private static AttractionModel attractionModel;
    public static final String DUMMY_ATTRACTION_LIST = "myanmar_attractions.json";

    private AttractionModel(){
        super();
        attractionVOList = initializeEventList();
    }


    public static AttractionModel getInstance() {

    if(attractionModel==null) {
        attractionModel = new AttractionModel();
    }
        return attractionModel;
    }

    public List<AttractionVO> getAttractionList() {

        return attractionVOList;

    }

    public AttractionVO getAttractionByTitle(String attractionTitle) {
        for (AttractionVO attractionVO : attractionVOList) {
            if (attractionVO.getTitle().equals(attractionTitle)) {
                return attractionVO;
            }
        }
        return null;
    }

//    public String getRandomAttractionImage() {
//        if (attractionVOList == null || attractionVOList.size() == 0) {
//            return null;
//        }
//
//        Random random = new Random();
//        int randomInt = random.nextInt(attractionVOList.size());
//
//        AttractionVO attraction = attractionVOList.get(randomInt);
//        return MyanmarAttractionsConstants.IMAGE_ROOT_DIR + attraction.getImages()[attraction.getImages().length - 1];
//    }



        private List<AttractionVO> initializeEventList(){

        List<AttractionVO> attractList = new ArrayList<>();

        try{
            String dummyAttractiontList = JsonUtils.getInstance().loadDummyData(DUMMY_ATTRACTION_LIST);
            Type listType = new TypeToken<List<AttractionVO>>() {
            }.getType();

            attractList = CommonInstances.getGsonInstance().fromJson(dummyAttractiontList, listType);
        }catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return attractList;
    }

    public List<AttractionVO> getAttractionVOList(){
        return attractionVOList;
    }


}
