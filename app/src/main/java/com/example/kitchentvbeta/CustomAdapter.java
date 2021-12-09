package com.example.kitchentvbeta;

import static com.example.kitchentvbeta.FBREF.AUTH;
import static com.example.kitchentvbeta.FBREF.storageRef;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.storage.StorageReference;
import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {
    Context context;
    ArrayList<Meal> mealList;
    LayoutInflater inflater;

    /**
     * constactor.
     * @param context app context
     * @param mealList the list.
     */
    public CustomAdapter(Context context,ArrayList<Meal>mealList){
        this.context=context;
        this.mealList=mealList;
        inflater=(LayoutInflater.from(context));
    }

    /**
     * @return the list size.
     */
    @Override
    public int getCount() {
        return mealList.size();
    }

    /**
     *
     * @param i the item id.
     * @return the place in the list of the  object.
     */
    @Override
    public Object getItem(int i) {
        return mealList.get(i);
    }

    /**
     *
     * @param i the item in the list.
     * @return the id
     */
    @Override
    public long getItemId(int i) {
        return 0;
    }

    /**
     *
     * @param i place clicked in list.
     * @param view the view in the list(row).
     * @param viewGroup
     * @return the view.
     */
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view=inflater.inflate(R.layout.custom_lv,null);
        TextView price=(TextView) view.findViewById(R.id.mPrice);
        TextView name=(TextView) view.findViewById(R.id.mName);
        TextView des=(TextView) view.findViewById(R.id.desc);
        ImageView photo=(ImageView) view.findViewById(R.id.mImage);
        Meal m=mealList.get(i);
        des.setText(m.getAbout());
        name.setText(m.getName());
        price.setText(((Double) m.getPrice()).toString());
        // set photo from fb here.
        FirebaseUser user = AUTH.getCurrentUser();
        if(user!=null) {
            StorageReference pathReference = storageRef.child("images/" +m.getCategory()+m.getName() + ".jpg");

            final long ONE_MEGABYTE = 1024 * 1024;
            pathReference.getBytes(ONE_MEGABYTE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
                /**
                 * when download is succesfull shows image
                 * <p>
                 * @param bytes the byte array (image).
                 */
                @Override
                public void onSuccess(byte[] bytes) {
                    Bitmap bitmap = BitmapFactory.decodeByteArray(bytes , 0, bytes .length);
                    photo.setImageBitmap(bitmap);
                }
            }).addOnFailureListener(new OnFailureListener() {
                /**
                 * when download photo from fb fails shows toast to notify user.
                 * @param exception the failure exception.
                 */
                @Override
                public void onFailure(@NonNull Exception exception) {
                    Toast.makeText(context, "cant find image for this meal", Toast.LENGTH_SHORT).show();
                }
            });
        }


        return view;
    }
}
