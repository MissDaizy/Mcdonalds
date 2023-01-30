
# Steps

A brief description of what this project does and who it's for


## Usage/Examples

step 1 - Add dependencies to project:

```java harmony
ext {
    daggerVersion = '2.44.2'
    paging_version = '3.1.1'
    room_version = "2.2.5"
    lifecycle_version = "2.5.1"
}  

dependencies {
    ...

    //*** Retrofit library for database of movies ****************************
    implementation 'com.squareup.retrofit2:retrofit:2.9.0'
    //*** Gson **********************************************************
    implementation 'com.squareup.retrofit2:converter-gson:2.9.0'

    // *** Glide Library **********************************************************
    implementation 'com.github.bumptech.glide:glide:4.13.2'
    annotationProcessor 'com.github.bumptech.glide:compiler:4.13.2'

    // *** Pagination Library **********************************************************
    implementation "androidx.paging:paging-runtime:$paging_version"
    implementation 'androidx.lifecycle:lifecycle-viewmodel-ktx:2.5.1'


    // *** Room **********************************************************
    implementation "androidx.room:room-runtime:$room_version"
    annotationProcessor "androidx.room:room-compiler:$room_version"
    implementation "androidx.room:room-rxjava2:$room_version"

    // *** RxJava3 **********************************************************
    implementation 'io.reactivex.rxjava3:rxandroid:3.0.0'
    implementation 'io.reactivex.rxjava3:rxjava:3.0.2'
    implementation "com.github.akarnokd:rxjava3-retrofit-adapter:3.0.0"
}

```

step 2 - Add ViewBinding:

```java harmony
    buildFeatures {
        viewBinding true
    }
```

step 4 - Add keys to keymap :

```raw
Shift+F - blank Fragment
Shift+A - blank Activity
Shift+P - create new package
Shift+J - new java class
```

step 5 - Add drawables:

(5.1) bg_white_rounded:

```xml harmony
    <?xml version="1.0" encoding="utf-8"?>
<shape xmlns:android="http://schemas.android.com/apk/res/android">
    <solid android:color="#ffffff"/>
    <corners android:radius="10dp"/>
    <padding android:left="0dp"
        android:bottom="0dp"
        android:right="0dp"
        android:top="0dp"/>
</shape>
```

(5.2) ic_arrow_downward:
```xml harmony
<vector android:height="24dp" android:tint="#000000"
    android:viewportHeight="24" android:viewportWidth="24"
    android:width="24dp" xmlns:android="http://schemas.android.com/apk/res/android">
    <path android:fillColor="@android:color/white" android:pathData="M20,12l-1.41,-1.41L13,16.17V4h-2v12.17l-5.58,-5.59L4,12l8,8 8,-8z"/>
</vector>

```
(5.3) ic_arrow_upward:
```xml harmony
<vector android:height="24dp" android:tint="#000000"
    android:viewportHeight="24" android:viewportWidth="24"
    android:width="24dp" xmlns:android="http://schemas.android.com/apk/res/android">
    <path android:fillColor="@android:color/white" android:pathData="M4,12l1.41,1.41L11,7.83V20h2V7.83l5.58,5.59L20,12l-8,-8 -8,8z"/>
</vector>

```

(5.4) ic_no_image:
```xml harmony
<vector android:height="24dp" android:tint="#000000"
    android:viewportHeight="24" android:viewportWidth="24"
    android:width="24dp" xmlns:android="http://schemas.android.com/apk/res/android">
    <path android:fillColor="@android:color/white" android:pathData="M21.9,21.9l-8.49,-8.49l0,0L3.59,3.59l0,0L2.1,2.1L0.69,3.51L3,5.83V19c0,1.1 0.9,2 2,2h13.17l2.31,2.31L21.9,21.9zM5,18l3.5,-4.5l2.5,3.01L12.17,15l3,3H5zM21,18.17L5.83,3H19c1.1,0 2,0.9 2,2V18.17z"/>
</vector>

```

step 6 -

(6.1) Create package **ui** -> **object_list**, **object_details**.

(6.2) Create *object_list* -> **activity** Then move the MainActivity to there and rename it to ObjectListActivity.

(6.3) Rename also the activity_main_layout.

(6.4) In activity_object_list:

```xml harmony
    <?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context=".ui.menu_item_list.activity.MenuItemListActivity">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical">

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="0dp"
            android:layout_weight="1"
            android:background="#EFECEC"
            android:orientation="vertical">

            <SearchView
                android:id="@+id/activityMenuItemList_SV_searchView"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:layout_margin="20dp"
                android:background="@drawable/bg_white_rounded"
                android:drawablePadding="12dp"
                android:ems="10"
                android:hint="@string/search_menu_items"
                android:padding="5dp"
                android:textColor="@color/black"
                android:textColorHint="@color/black"
                android:textSize="16sp"/>

            <LinearLayout
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:layout_margin="10dp"
                android:orientation="horizontal">

                <com.google.android.material.button.MaterialButton
                    android:id="@+id/activityMenuItemList_BTN_allFilter"
                    style="@style/Widget.MaterialComponents.Button.OutlinedButton.Icon"
                    android:layout_width="0dp"
                    android:layout_height="match_parent"
                    android:layout_weight="1"
                    android:text="@string/filter_show_all"
                    android:textSize="10sp" />

                <com.google.android.material.button.MaterialButton
                    android:id="@+id/activityMenuItemList_BTN_ascCaloriesFilter"
                    style="@style/Widget.MaterialComponents.Button.OutlinedButton.Icon"
                    android:layout_width="0dp"
                    android:layout_height="match_parent"
                    android:layout_weight="2"
                    android:fontFamily="sans-serif"
                    android:text="@string/filter_calories"
                    android:textSize="10sp"
                    app:icon="@drawable/ic_arrow_upward" />

                <com.google.android.material.button.MaterialButton
                    android:id="@+id/activityMenuItemList_BTN_descCaloriesFilter"
                    style="@style/Widget.MaterialComponents.Button.OutlinedButton.Icon"
                    android:layout_width="0dp"
                    android:layout_height="match_parent"
                    android:layout_weight="2"
                    android:fontFamily="sans-serif"
                    android:text="@string/filter_calories"
                    android:textSize="10sp"
                    app:icon="@drawable/ic_arrow_downward" />

                <com.google.android.material.button.MaterialButton
                    android:id="@+id/activityMenuItemList_BTN_titleFilter"
                    style="@style/Widget.MaterialComponents.Button.OutlinedButton.Icon"
                    android:layout_width="0dp"
                    android:layout_height="match_parent"
                    android:layout_weight="1"
                    android:fontFamily="sans-serif"
                    android:text="@string/name"
                    android:textSize="10sp" />

            </LinearLayout>

            <androidx.recyclerview.widget.RecyclerView
                android:id="@+id/activityMenuItemList_RV_recyclerView"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:layout_margin="5dp" />

            <ProgressBar
                android:id="@+id/activityMenuItemList_PB_progressBar"
                style="?android:attr/progressBarStyle"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:layout_gravity="center"
                android:layout_margin="100dp" />
        </LinearLayout>

    </LinearLayout>

</LinearLayout>

```
 

step 7 - 

(7.1) Create *object_details* -> **activity** -> **ObjectDetailsActivity**.

(7.2) in activity_object_details:
```xml harmony
    <?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".ui.menu_item_details.activity.MenuItemDetailsActivity">
    <ScrollView
        android:layout_width="match_parent"
        android:layout_height="match_parent">

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:orientation="vertical">

            <androidx.cardview.widget.CardView
                android:id="@+id/fragmentRecipeDetails_CV_recipeItemCard"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:layout_gravity="center"
                android:layout_margin="10dp"
                android:clickable="true"
                android:focusable="true"
                app:cardBackgroundColor="@color/white"
                app:cardCornerRadius="10dp"
                app:cardElevation="10dp">

                <LinearLayout
                    android:id="@+id/list_item_layout"
                    android:layout_width="match_parent"
                    android:layout_height="match_parent"
                    android:orientation="vertical">

                    <TextView
                        android:id="@+id/recipeListItem_TXT_title"
                        android:layout_width="wrap_content"
                        android:layout_height="wrap_content"
                        android:layout_margin="10dp"
                        android:fontFamily="sans-serif"
                        android:text="@string/name"
                        android:textColor="@color/black"
                        android:textSize="30sp"
                        android:textStyle="bold" />

                    <ImageView
                        android:id="@+id/recipeListItem_IMG_recipeImage"
                        android:layout_width="match_parent"
                        android:layout_height="150dp"
                        android:contentDescription="@string/image"
                        android:src="@drawable/ic_no_image" />

                        <TextView
                            android:id="@+id/fragmentRecipeDetails_TXT_descriptionPreview"
                            android:layout_width="wrap_content"
                            android:layout_height="wrap_content"
                            android:layout_margin="10dp"
                            android:fontFamily="sans-serif"
                            android:text="Description:"
                            android:textColor="@color/black"
                            android:textSize="20sp" />

                        <TextView
                            android:id="@+id/fragmentRecipeDetails_TXT_description"
                            android:layout_width="wrap_content"
                            android:layout_height="wrap_content"
                            android:layout_margin="10dp"
                            android:fontFamily="sans-serif"
                            android:text="DESCRIPTION"
                            android:textColor="@color/black"
                            android:textSize="20sp" />
                </LinearLayout>
            </androidx.cardview.widget.CardView>
                </LinearLayout>

    </ScrollView>

</LinearLayout>
```

step 7 - Create object_list_item:

```xml harmony
    <?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    xmlns:app="http://schemas.android.com/apk/res-auto">
    <androidx.cardview.widget.CardView
        android:id="@+id/menuListItem_CV_menuItemCard"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_gravity="center"
        android:layout_margin="10dp"
        android:clickable="true"
        android:focusable="true"
        app:cardBackgroundColor="@color/white"
        app:cardCornerRadius="10dp"
        app:cardElevation="10dp">

        <LinearLayout
            android:id="@+id/list_item_layout"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:orientation="vertical">

            <TextView
                android:id="@+id/menuListItem_TXT_title"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_margin="10dp"
                android:fontFamily="sans-serif-black"
                android:text="@string/name"
                android:textColor="@color/black"
                android:textSize="25sp"
                android:textStyle="bold" />

            <ImageView
                android:id="@+id/menuListItem_IMG_recipeImage"
                android:layout_width="match_parent"
                android:layout_height="150dp"
                android:contentDescription="@string/image"
                android:src="@drawable/ic_no_image" />
            <LinearLayout
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:orientation="horizontal">
                <TextView
                    android:id="@+id/menuListItem_TXT_caloriesPreview"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:layout_margin="10dp"
                    android:fontFamily="sans-serif-black"
                    android:text="Calories:"
                    android:textColor="@color/black"
                    android:textSize="20sp" />
                <TextView
                    android:id="@+id/menuListItem_TXT_calories"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:layout_margin="10dp"
                    android:fontFamily="sans-serif-black"
                    android:text="@string/calories"
                    android:textColor="@color/black"
                    android:textSize="20sp" />
            </LinearLayout>



        </LinearLayout>
    </androidx.cardview.widget.CardView>
</LinearLayout>
```

Step 8 - Look at the JSON and build models in **data** -> **model**.
Be aware of the Types!!!

(8.1)  **ObjectItem** with sorting parameters:

```java harmony
    public static class SortByTitle implements Comparator<MenuItem> {
        // Used for sorting title
        public int compare(MenuItem m1, MenuItem m2) {
            return m1.getItem().compareTo(m2.getItem());
        }
    }
    public static class SortByCalories implements Comparator<MenuItem> {
        // Used for sorting in ascending order of
        // roll number
        public int compare(MenuItem m1, MenuItem m2) {
            return m1.getCalories() - m2.getCalories();
        }
    }

```


(8.2) **ObjectDetails**

 Step 9 - Create **common** -> **Constants**:

```java harmony
   public class Constants {
    public static final String BASE_URL="https://api.npoint.io/";
    public static final String LOG="Log";
    public static final String SELECTED_ITEM =  "Selected Item";
    public static final String ITEM_DETAILS =  "Item Details";
}

```


Step 9 - Create *data* -> **remote** ->

(9.1) **JsonApiObject**:
```java harmony
public interface JsonApiMenuItem {
    // The List of menu items
    @GET("eb45e4d55e58098c1537")
    Observable<List<MenuItem>> getAllMenuItems();

    // More details of a specific menu item
    @GET("{menuItemUrlId}")
    Observable<MenuItemDetails> getMenuItemDetails(
            @Path("menuItemUrlId") String id
    );
}

```

(9.2) **ApiService**:

```java harmony
public class ApiService {

    private static ApiService INSTANCE = null;
    private JsonApiMenuItem jsonApiMenuItem;
    private ApiService() {
        initializeRetrofit();
    }

    public static ApiService getInstance() {
        if (INSTANCE == null)
            INSTANCE = new ApiService();

        return INSTANCE;
    }

    private void initializeRetrofit() {
        jsonApiMenuItem =new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build()
                .create(JsonApiMenuItem.class);
    }

    public JsonApiMenuItem getJsonApiMenuItem() {
        return jsonApiMenuItem;
    }
}

```

Step 10 - Create **repository** -> **Repository**:

```java harmony
public class Repository {
    private static Repository INSTANCE = null;

    private JsonApiMenuItem jsonApiMenuItem;
    public static Repository getInstance() {
        if (INSTANCE == null)
            INSTANCE = new Repository();

        return INSTANCE;
    }
    private Repository( ) {
        this.jsonApiMenuItem = ApiService.getInstance().getJsonApiMenuItem();
    }

    public Observable<List<MenuItem>> getAllMenuItems(){
        return jsonApiMenuItem.getAllMenuItems();
    }
    public Observable<MenuItemDetails> getMenuItemDetails(String menuItemUrlId){
        return jsonApiMenuItem.getMenuItemDetails(menuItemUrlId);
    }
}

```

Step 11 - Create **util** -> **ImageUtil**:

```java harmony
public class ImageUtil {
    public static void setImage(Context context, String imageUrl, ImageView imageView,int width,int height) {
        Glide.with(context)
                .load(imageUrl)
                .override(width, height)
                .into(imageView);
    }
}

```

Step 12 - Create *ui* -> **callback** ->

(12.1) 🟢**CustomItemClickListener**:

```java harmony
public interface CustomItemClickListener {
    void onClick(Object object);
}

```

(12.2) **ObjectDiffCallback**:

```java harmony
public class MenuItemDiffCallback extends DiffUtil.Callback {
    private final List<MenuItem> mOldMenuItemList;
    private final List<MenuItem> mNewMenuItemList;

    public MenuItemDiffCallback(List<MenuItem> oldRecipeList, List<MenuItem> newRecipeList) {
        this.mOldMenuItemList = oldRecipeList;
        this.mNewMenuItemList = newRecipeList;
    }

    @Override
    public int getOldListSize() {
        return mOldMenuItemList.size();
    }

    @Override
    public int getNewListSize() {
        return mNewMenuItemList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return mOldMenuItemList.get(oldItemPosition).equals(mNewMenuItemList.get(
                newItemPosition));
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        final MenuItem oldRecipe = mOldMenuItemList.get(oldItemPosition);
        final MenuItem newRecipe = mNewMenuItemList.get(newItemPosition);

        return oldRecipe.equals(newRecipe);
    }

    @Nullable
    @Override
    public Object getChangePayload(int oldItemPosition, int newItemPosition) {
        return super.getChangePayload(oldItemPosition, newItemPosition);
    }
}

```

Step 13 - In *ui* -> *object_item_list* ->

(13.1) Create **FilterType**:

```java harmony
public enum FilterType {
    ALL,NAME,ASC_CALORIES,DESC_CALORIES
}
```

(13.2) Create **ObjectListEvent**:
```java harmony
public enum MenuItemListEvent {
    FILTER_LIST,ITEM_CLICKED,SEARCH
}

```

Step 14 - Create *ui* -> *object_item_list* -> **adapter** -> **ObjectAdapter**:

```java harmony
public class MenuItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private MenuListItemBinding menuListItemBinding;
    private List<MenuItem> menuItemList;
    private CustomItemClickListener customItemClickListener;

    private Context context;

    private static final int RECIPE_IMAGE_WIDTH=1000;
    private static final int RECIPE_IMAGE_HEIGHT=1000;

    public MenuItemAdapter(Context context) {
        this.customItemClickListener= (CustomItemClickListener) context;
        this.menuItemList = new ArrayList<>();
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        menuListItemBinding = MenuListItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new MyViewHolder(menuListItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MenuItem menuItem = menuItemList.get(position);

        MyViewHolder myViewHolder = (MyViewHolder) holder;
        setListeners(myViewHolder,menuItem);
        myViewHolder.menuListItemBinding.menuListItemTXTTitle.setText(menuItem.getItem());
        myViewHolder.menuListItemBinding.menuListItemTXTCalories.setText(""+menuItem.getCalories());
    }

    private void setListeners(MyViewHolder myViewHolder, MenuItem menuItem) {
        myViewHolder.menuListItemBinding.menuListItemCVMenuItemCard.setOnClickListener(v->{
            customItemClickListener.onClick(menuItem);
        });
    }

    @Override
    public int getItemCount() {
        return menuItemList.size();
    }

    public void updateRecipeListItems(List<MenuItem> menuItems) {
        final MenuItemDiffCallback diffCallback = new MenuItemDiffCallback(this.menuItemList, menuItems);
        final DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(diffCallback);

        this.menuItemList.clear();
        this.menuItemList.addAll(menuItems);
        this.notifyDataSetChanged();
        diffResult.dispatchUpdatesTo(this);
    }
    class MyViewHolder extends RecyclerView.ViewHolder {
        private MenuListItemBinding menuListItemBinding;

        public MyViewHolder(MenuListItemBinding menuListItemBinding) {
            super(menuListItemBinding.getRoot());
            this.menuListItemBinding = menuListItemBinding;

        }
    }
}

```

Step 15 - Create *ui* -> *object_item_list* -> **ObjectItemListViewModel**:

```java harmony
public class MenuItemListViewModel extends ViewModel {

    // Variable the Menu Item List
    private MutableLiveData<List<MenuItem>> menuItemLiveData;
    // Variable of the filtered Menu Item List
    private MutableLiveData<List<MenuItem>> filteredMenuItemLiveData;
    // Variable of the Selected Menu Item
    private MutableLiveData<MenuItem> selectedMenuItem;
    // Variable for hiding and showing the loading spinner
    private MutableLiveData<Boolean> loading;
    private MutableLiveData<String> currentSearchTextLiveData;
    private PublishSubject<List<MenuItem>> menuItemsSubject;
    private CompositeDisposable disposables;
    private Repository repository;
    private FilterType selectedFilter;


    public MenuItemListViewModel() {
        this.repository = Repository.getInstance();

        init();
        subscribeSubject();
    }

    private void init() {
        menuItemLiveData = new MutableLiveData<>();
        filteredMenuItemLiveData = new MutableLiveData<>();
        selectedMenuItem = new MutableLiveData<>();
        loading = new MutableLiveData<>();
        currentSearchTextLiveData = new MutableLiveData<>("");

        menuItemsSubject = PublishSubject.create();
        disposables = new CompositeDisposable();
        selectedFilter = FilterType.ALL;
    }

    private void subscribeSubject() {
        Disposable disposable =
                repository.getAllMenuItems()
                        .subscribeOn(Schedulers.io())
                        .subscribe(menuItemsSubject::onNext, throwable -> {
                            Log.e(Constants.LOG, "From SubscribeSubject error: " + throwable.getMessage());
                        });
        disposables.add(disposable);
    }

    public MutableLiveData<List<MenuItem>> getMenuItemLiveData() {
        return menuItemLiveData;
    }

    public MutableLiveData<List<MenuItem>> getFilteredMenuItemLiveData() {
        return filteredMenuItemLiveData;
    }

    public MutableLiveData<MenuItem> getSelectedMenuItem() {
        return selectedMenuItem;
    }

    public MutableLiveData<Boolean> getLoading() {
        return loading;
    }

    public MutableLiveData<String> getCurrentSearchTextLiveData() {
        return currentSearchTextLiveData;
    }

    public void getMenuItems() {
        menuItemsSubject
                .debounce(400, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                // No need to map
                .subscribe(new Observer<List<MenuItem>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        loading.setValue(true);
                        disposables.add(d);
                    }

                    @Override
                    public void onNext(@NonNull List<MenuItem> menuItems) {
                        loading.setValue(false);
                        menuItemLiveData.setValue(menuItems);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.e(Constants.LOG, "getMenuItems error: " + e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        // Nothing to do here
                    }
                });
    }


    public void onEventMenuItemList(MenuItemListEvent event, Object object) {
        switch (event) {
            case FILTER_LIST: {
                selectedFilter = (FilterType) object;
                filterList();
                break;
            }
            case SEARCH: {
                String searchQuery=(String)object;
               searchMenuItems(searchQuery.toLowerCase());
               if(filteredMenuItemLiveData.getValue()!=null) {
                   if(filteredMenuItemLiveData.getValue().isEmpty())
                       loading.setValue(false);
               }

               break;
            }
        }
    }

    private void filterList() {
        List<MenuItem> filteredMenuItems;
        if (menuItemLiveData.getValue() == null)
            return;
        else if (filteredMenuItemLiveData.getValue() == null)
            filteredMenuItems = menuItemLiveData.getValue();
        else
            filteredMenuItems = filteredMenuItemLiveData.getValue();

         filterCases(filteredMenuItems);
    }
        private void filterCases(List<MenuItem> filteredMenuItems) {
        switch (selectedFilter) {
            case ALL:
                currentSearchTextLiveData.setValue("");
                filteredMenuItemLiveData.setValue(menuItemLiveData.getValue());
                break;
            case ASC_CALORIES:
                Collections.sort(filteredMenuItems, new MenuItem.SortByCalories().reversed());
                filteredMenuItemLiveData.setValue(filteredMenuItems);
                break;
            case DESC_CALORIES:
                Collections.sort(filteredMenuItems, new MenuItem.SortByCalories());
                filteredMenuItemLiveData.setValue(filteredMenuItems);
                break;
            case NAME:
                Collections.sort(filteredMenuItems, new MenuItem.SortByTitle());
                filteredMenuItemLiveData.setValue(filteredMenuItems);
                break;
        }
    }
    public void disposeComposite() {
        disposables.dispose();
    }

    public void searchMenuItems(String searchQuery) {
        currentSearchTextLiveData.setValue(searchQuery);
        List<MenuItem> filteredMenuItems = new ArrayList<>();
        if (menuItemLiveData.getValue() != null) {
            for (MenuItem menuItem : menuItemLiveData.getValue()) {
                if (menuItem.getItem().toLowerCase().contains(searchQuery)) {
                    filteredMenuItems.add(menuItem);
                }
            }
            filteredMenuItemLiveData.setValue(filteredMenuItems);
        }
    }
}

```

Step 16 - In *ui* -> *object_item_list* -> *activity* -> *ObjectListActivity*:

```java harmony
public class MenuItemDetailsActivity extends AppCompatActivity   {
    private static final int HEIGHT =1000 ;
    private static final int WIDTH =1000 ;
    private MenuItemViewModel menuItemViewModel;

    private ActivityMenuItemDetailsBinding activityMenuItemDetailsBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_item_details);

        activityMenuItemDetailsBinding = ActivityMenuItemDetailsBinding.inflate(getLayoutInflater());
        View view = activityMenuItemDetailsBinding.getRoot();
        setContentView(view);

        setUI();
    }

    private void setUI() {
        MenuItem menuItem=getItemData();
        MenuItemDetails menuItemDetails = getItemDetails();
        setMenuItemUI(menuItem);
        setMenuItemDetailsUI(menuItemDetails);
    }

    private MenuItem getItemData() {
        Bundle bundle = getIntent ().getExtras ();
        String selectedItemJson = bundle.getString (Constants.SELECTED_ITEM);
        MenuItem selectedItem = new Gson().fromJson (selectedItemJson, MenuItem.class);
        return  selectedItem;
    }

    private MenuItemDetails getItemDetails() {
        Bundle bundle = getIntent ().getExtras ();
        String itemDetailsJson = bundle.getString (Constants.ITEM_DETAILS);
        MenuItemDetails menuItemDetails = new Gson().fromJson (itemDetailsJson, MenuItemDetails.class);
        return menuItemDetails;
    }

    private void setMenuItemUI(MenuItem selectedItem) {
        activityMenuItemDetailsBinding.recipeListItemTXTTitle.setText(selectedItem.getItem());
    }

    private void setMenuItemDetailsUI(MenuItemDetails menuItemDetails) {
        activityMenuItemDetailsBinding.fragmentRecipeDetailsTXTDescription.setText(menuItemDetails.getDescription());
        setImageUI(menuItemDetails.getImageUrl());
    }

    private void setImageUI(String imageUrl) {
        ImageUtil.setImage(this,imageUrl,activityMenuItemDetailsBinding.recipeListItemIMGRecipeImage,WIDTH,HEIGHT);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}

```

Step 17 - Create *ui* -> *object_details* -> **ObjectItemEvent**:

```java harmony
public enum MenuItemEvent {
    GET_MENU_ITEM_DETAILS
}

```

Step 18 - Create *ui* -> *object_details* -> **ObjectItemViewModel**:

```java harmony
public class MenuItemViewModel extends ViewModel {
    private MutableLiveData<MenuItemDetails> menuItemDetailsLiveData;
    private MutableLiveData<MenuItem> selectedItem;
    private Repository repository;
    private CompositeDisposable disposables;
    private PublishSubject<MenuItemDetails> menuItemDetailsSubject;



    public MenuItemViewModel( ) {
        this.repository = Repository.getInstance();


        init();
    }

    private void init() {
        menuItemDetailsLiveData = new MutableLiveData<>();
        selectedItem = new MutableLiveData<>();
        disposables = new CompositeDisposable();

        menuItemDetailsSubject = PublishSubject.create();
    }

    public void subscribeSubject(String menuItemUrl) {
        Disposable disposable =
                repository.getMenuItemDetails(menuItemUrl)
                        .subscribeOn(Schedulers.io())
                        .subscribe(menuItemDetailsSubject::onNext, throwable -> {
                            Log.e(Constants.LOG, "subscribeSubject error: " + throwable.getMessage());
                        });
        disposables.add(disposable);

    }

    public MutableLiveData<MenuItemDetails> getMenuItemDetailsLiveData() {
        return menuItemDetailsLiveData;
    }

    public MutableLiveData<MenuItem> getSelectedItem() {
        return selectedItem;
    }

    public void getMenuItemDetails() {
        menuItemDetailsSubject
                .debounce(400, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<MenuItemDetails>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        disposables.add(d);
                    }

                    @Override
                    public void onNext(@NonNull MenuItemDetails menuItemDetails) {
                        menuItemDetailsLiveData.setValue(menuItemDetails);

                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.e(Constants.LOG, "getMenuItemDetails error: " + e.getMessage());

                    }

                    @Override
                    public void onComplete() {
                        // Nothing to do here

                    }
                });

    }

    public void onEventRecipeList(MenuItemEvent getMenuItemDetails, Object object) {
        switch (getMenuItemDetails) {
            case GET_MENU_ITEM_DETAILS:
                MenuItem menuItem = (MenuItem) object;
                selectedItem.setValue(menuItem);
                subscribeSubject(menuItem.getId());
                getMenuItemDetails();
                break;

        }

    }
}

```

Step 19 - Create *ui* -> *object_details* -> *activity* -> **ObjectItemDetailsActivity**:

```java harmony
public class MenuItemDetailsActivity extends AppCompatActivity   {
    private static final int HEIGHT =1000 ;
    private static final int WIDTH =1000 ;
    private MenuItemViewModel menuItemViewModel;

    private ActivityMenuItemDetailsBinding activityMenuItemDetailsBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_item_details);

        activityMenuItemDetailsBinding = ActivityMenuItemDetailsBinding.inflate(getLayoutInflater());
        View view = activityMenuItemDetailsBinding.getRoot();
        setContentView(view);

        setUI();
    }

    private void setUI() {
        MenuItem menuItem=getItemData();
        MenuItemDetails menuItemDetails = getItemDetails();
        setMenuItemUI(menuItem);
        setMenuItemDetailsUI(menuItemDetails);
    }

    private MenuItem getItemData() {
        Bundle bundle = getIntent ().getExtras ();
        String selectedItemJson = bundle.getString (Constants.SELECTED_ITEM);
        MenuItem selectedItem = new Gson().fromJson (selectedItemJson, MenuItem.class);
        return  selectedItem;
    }

    private MenuItemDetails getItemDetails() {
        Bundle bundle = getIntent ().getExtras ();
        String itemDetailsJson = bundle.getString (Constants.ITEM_DETAILS);
        MenuItemDetails menuItemDetails = new Gson().fromJson (itemDetailsJson, MenuItemDetails.class);
        return menuItemDetails;
    }

    private void setMenuItemUI(MenuItem selectedItem) {
        activityMenuItemDetailsBinding.recipeListItemTXTTitle.setText(selectedItem.getItem());
    }

    private void setMenuItemDetailsUI(MenuItemDetails menuItemDetails) {
        activityMenuItemDetailsBinding.fragmentRecipeDetailsTXTDescription.setText(menuItemDetails.getDescription());
        setImageUI(menuItemDetails.getImageUrl());
    }

    private void setImageUI(String imageUrl) {
        ImageUtil.setImage(this,imageUrl,activityMenuItemDetailsBinding.recipeListItemIMGRecipeImage,WIDTH,HEIGHT);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}

```

Step 20 - 

Implement searching and filtering.




