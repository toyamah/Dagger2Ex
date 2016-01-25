package htoyama.full_use.presentation.main;

import android.os.SystemClock;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Component;
import htoyama.full_use.App;
import htoyama.full_use.AppComponent;
import htoyama.full_use.R;
import htoyama.full_use.TestModule;
import htoyama.full_use.domain.item.Item;
import htoyama.full_use.domain.item.ItemRepository;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    @Inject ItemRepository mRepository;

    @Singleton
    @Component(modules = TestModule.class)
    public interface TestComponent extends AppComponent {
        void inject(MainActivityTest test);
    }

    @Rule
    public ActivityTestRule<MainActivity> mTestRule = new ActivityTestRule<>(
            MainActivity.class,
            true,
            false);

    @Before
    public void setUp() {
        TestComponent c = DaggerMainActivityTest_TestComponent.builder()
                .build();
        c.inject(this);

        App app = (App) InstrumentationRegistry.getTargetContext()
                .getApplicationContext();
        app.setComponent(c);
    }

    @Test
    public void flakyなテストをDagger2で回避することもやろうと思えばできる() {
        final Item expected = mRepository.find();
        mTestRule.launchActivity(null);

        SystemClock.sleep(2000);

        onView(withId(R.id.item_name))
                .check(matches(withText(expected.name())));
        onView(withId(R.id.item_price))
                .check(matches(withText(String.valueOf(expected.price()))));
    }

}