# LeveledViewPager

This is a custom viewPager that allows to ensure that a selected view is of the same height in all of its pages.

### Gradle

Import to android studio:

```Gradle
allprojects {
    repositories {
        jcenter()
        maven { url "https://jitpack.io" }
    }
}

dependencies {
	compile 'com.github.SimplyJaymin:LeveledViewPager:0.1.1'
}
```
### Usage

Add it to the XML layout
```android
<com.android.jminlabs.leveledviewpager.LeveledViewPager
        android:id="@+id/viewPager"
        android:layout_width="match_parent"
        android:layout_height="match_parent"/>
```

```android
public class MainActivity extends AppCompatActivity {
  ...
  @BindView(R.id.viewPager) LeveledViewPager mLeveledViewPager;
  ...

  @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        // Create List of fragments, add to adapter & set to viewPager
        // text_container is the id of the View that you want to maintain the SAME height across all the pages of the viewPager
        mLeveledViewPager.setViewIdToLevel(R.id.text_container);
        mLeveledViewPager.setOffscreenPageLimit(adapter.getCount());
    }

}
```
