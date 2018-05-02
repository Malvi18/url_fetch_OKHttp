package com.example.android_job_project.stringofobjects;


import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android_job_project.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {
    private ArrayList<Model> ModelList;
    private RecyclerView recyclerView;
    private UserAdapater userAdapater;

    String url="http://androidhitesh.890m.com/hitesh/message_json.php";


    public BlankFragment() {
        // Required empty public constructor
    }
        @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_blank3, container, false);
        ModelList = new ArrayList<Model>();
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        userAdapater = new UserAdapater(getActivity(), ModelList);

        recyclerView.setAdapter(userAdapater);


        new JsonDataClass().execute(url);
        return view;
    }

    private class JsonDataClass extends AsyncTask<String,Void,String> {

        @Override
        protected String doInBackground(String... strings) {
            OkHttpClient okHttpClient = new OkHttpClient();
            Request request = new Request.Builder().url(strings[0]).build();
            try {
                Response response = okHttpClient.newCall(request).execute();
                String data = response.body().string();
                return data;
            } catch (IOException e) {
                e.printStackTrace();

            }
            return null;

        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {

                JSONArray jsonArray=new JSONArray(s);

                for(int i=0;i<jsonArray.length();i++){
                    JSONObject jsonObject1=jsonArray.getJSONObject(i);
                    Model model=new Model();
                    model.setId(jsonObject1.getInt("cid"));
                    model.setName(jsonObject1.getString("cname"));

                    ModelList.add(model);

                }
                userAdapater.notifyDataSetChanged();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
