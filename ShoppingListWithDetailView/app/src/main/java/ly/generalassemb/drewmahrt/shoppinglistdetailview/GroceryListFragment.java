package ly.generalassemb.drewmahrt.shoppinglistdetailview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by student on 11/1/16.
 */

public class GroceryListFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private OnGrocerySelectedListener mListener;


    public interface OnGrocerySelectedListener{
        public void onGrocerySelected(int id);
    }

    public static Fragment newInstance(Bundle bundle, OnGrocerySelectedListener listener){
        GroceryListFragment groceryListFragment = new GroceryListFragment();
        groceryListFragment.setArguments(bundle);
        groceryListFragment.mListener = listener;
        return groceryListFragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_grocery_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.shopping_list_recyclerview);

        List<ShoppingItem> shoppingItems = ShoppingSQLiteOpenHelper
                .getInstance(getContext())
                .getShoppingList();

        mRecyclerView.setLayoutManager(
                new LinearLayoutManager(getContext(),
                        LinearLayoutManager.VERTICAL,
                        false));

        mRecyclerView.setAdapter(new ShoppingListAdapter(shoppingItems, mListener));
    }
}
