package com.mye030.DataGeoGrapherApplication.dao;

import com.mye030.DataGeoGrapherApplication.model.ClimateDisastersTemperatureChange;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClimateDisastersTemperatureChangeDAO extends JpaRepository<ClimateDisastersTemperatureChange, Integer> {

    public List<ClimateDisastersTemperatureChange> findByisoCode(int isoCode);


    /* O xristis dialegei xwra -> psaxnoyme me to onoma kai pairnoume to antikeimeno xwra
     Country testCountry = CountryDAO.findByDisplayName(toOnomaApoToHTML);
    int iso_code_ths_xwras_pou_dialekse = testCountry.iso_code;

  Briskw me to iso code oles tis eggrafes sto climate
    List<ClimateDisastersTemperatureChange> testList = ClimateDisastersTemperatureChangeDAO.findByIsoCode(iso_code_ths_xwras_pou_dialekse)

     Psaxnw se ayth thn lista kai dialegw to time period poy thelei
     for (int i = 0; i < testList.size; i++){
          if (testList.get(i).year_ >= startingYear (pali apo to HTML to dinei o bro) && testList.get(i).year_ <= endingYear)
                 extraList gia na apothikeuoume tis xronies gia ton x aksona
                 yearList.add(testList.get(i).year)

                listaApotelesmaton.add(testList.get(i).temperature_change);

     Kai meta petame thn lista gia graph */
}

