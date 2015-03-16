package com.dnocode.google.apis.places.models;

import com.dnocode.google.apis.commons.models.MatchedSubstring;
import com.dnocode.google.apis.commons.models.Term;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

 public class Place implements Serializable{

        @Expose
        public String id;
        @SerializedName("place_id")
        @Expose
        public String placeId;
        @Expose
        public List<String> types = new ArrayList<String>();
        @SerializedName("matched_substrings")
        @Expose
        public List<MatchedSubstring> matchedSubstrings = new ArrayList<MatchedSubstring>();
        @Expose
        public String reference;
        @Expose
        public String description;
        @Expose
        public List<Term> terms = new ArrayList<Term>();


     public boolean containTerm(String constraint){

         for(Term term :terms){

             if(term.value.toLowerCase().equals(constraint.toLowerCase())){return true;}

         }

         return false;

     }

    }