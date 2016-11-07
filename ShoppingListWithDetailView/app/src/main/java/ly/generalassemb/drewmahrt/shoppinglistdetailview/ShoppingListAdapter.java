package ly.generalassemb.drewmahrt.shoppinglistdetailview;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by drewmahrt on 10/21/16.
 */

public class ShoppingListAdapter extends RecyclerView.Adapter<ShoppingItemViewHolder> {
    private List<ShoppingItem> mShoppingItems;
    private GroceryListFragment.OnGrocerySelectedListener mListener;

    public ShoppingListAdapter(List<ShoppingItem> shoppingItems, GroceryListFragment.OnGrocerySelectedListener listener) {
        mShoppingItems = shoppingItems;
        mListener = listener;
    }

    @Override
    public ShoppingItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ShoppingItemViewHolder(LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1,parent,false));
    }

    @Override
    public void onBindViewHolder(final ShoppingItemViewHolder holder, final int position) {

        final ShoppingItem currentItem = mShoppingItems.get(position);

        holder.mNameTextView.setText(currentItem.getName());

        holder.mNameTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onGrocerySelected(mShoppingItems.get(position).getId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mShoppingItems.size();
    }
}
