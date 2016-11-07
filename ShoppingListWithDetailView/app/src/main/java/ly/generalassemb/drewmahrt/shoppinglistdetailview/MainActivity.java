package ly.generalassemb.drewmahrt.shoppinglistdetailview;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ly.generalassemb.drewmahrt.shoppinglistdetailview.setup.DBAssetHelper;

public class MainActivity extends AppCompatActivity implements GroceryListFragment.OnGrocerySelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Ignore the two lines below, they are for setup
        DBAssetHelper dbSetup = new DBAssetHelper(MainActivity.this);
        dbSetup.getReadableDatabase();

        Fragment groceryListFragment = GroceryListFragment.newInstance(null, this);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, groceryListFragment)
                .commit();
    }

    @Override
    public void onGrocerySelected(int id) {
        Bundle bundle = new Bundle();
        bundle.putInt(DetailFragment.ITEM_ID_KEY, id);
        Fragment detailFragment = DetailFragment.newInstance(bundle);

        getSupportFragmentManager()
                .beginTransaction()
                .addToBackStack(null)
                .replace(R.id.fragment_container, detailFragment)
                .commit();
    }
}
