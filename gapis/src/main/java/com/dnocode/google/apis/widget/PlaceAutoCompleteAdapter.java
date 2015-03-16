package com.dnocode.google.apis.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.TextView;

import com.dnocode.google.apis.G;
import com.dnocode.google.apis.places.models.Place;
import com.dnocode.google.apis.places.query.AutoCompleteSearchQuery;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by st1x on 10/7/13.
 */

public class PlaceAutoCompleteAdapter extends ArrayAdapter<Place> {

    protected List<Place> mPlaces;
    protected LayoutInflater mInflater;
    private int mResource;
    protected AutoCompleteSearchQuery mQuery;

    public PlaceAutoCompleteAdapter(Context context, int textViewResourceId, AutoCompleteSearchQuery placeQuery) {
        super(context, textViewResourceId);
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mResource = textViewResourceId;
        mQuery = placeQuery;

    }

    @Override
    public int getCount() {
        return mPlaces.size();
    }

    @Override
    public Place getItem(int index) {
        return mPlaces.get(index);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return createView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return createView(position, convertView, parent);
    }

    private View createView(int position, View convertView, ViewGroup parent) {
        View view;
        TextView text;

        if (convertView == null) {
            view = mInflater.inflate(mResource, parent, false);
        } else {
            view = convertView;
        }
        text = (TextView) view;
        Place item = getItem(position);
        if (text != null) {
            text.setText(item.description);
        }
        return view;
    }

    @Override
    public Filter getFilter() {

        Filter filter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults filterResults = new FilterResults();
                if (constraint != null) {
                    // Retrieve the autocomplete results.
                    mPlaces = autocompletePlace(constraint.toString());
                    // Assign the data to the FilterResults
                    filterResults.values = mPlaces;
                    filterResults.count = mPlaces.size();
                }
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint,
                                          FilterResults results) {
                if (results != null && results.count > 0) {
                    notifyDataSetChanged();
                } else {
                    notifyDataSetInvalidated();
                }

            }
        };
        return filter;
    }

    protected List<Place> autocompletePlace(String constraint) {
        List<Place> places = new ArrayList<Place>();
        try {
            mQuery.setInput(constraint);

                 places = G.api(getContext()).places().getPredictions(mQuery);


        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return places;
    }

}
