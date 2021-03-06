package makarov.vk.vkgroupchats.ioc.chats.modules;

import android.support.v7.app.AppCompatActivity;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import makarov.vk.vkgroupchats.data.Storage;
import makarov.vk.vkgroupchats.data.query.QueryFactory;
import makarov.vk.vkgroupchats.presentation.BackPressedDispatcher;
import makarov.vk.vkgroupchats.presentation.UiNavigator;
import makarov.vk.vkgroupchats.presentation.presenters.ChatsListPresenter;
import makarov.vk.vkgroupchats.presentation.presenters.LoginPresenter;
import makarov.vk.vkgroupchats.presentation.presenters.PresenterFactory;
import makarov.vk.vkgroupchats.vk.VkManager;
import makarov.vk.vkgroupchats.vk.VkRequestsFactory;

@Module
public class ChatsModule {

    protected final AppCompatActivity mActivity;

    public ChatsModule(AppCompatActivity activity) {
        mActivity = activity;
    }

    @Provides
    @Singleton
    AppCompatActivity provideAppCompatActivity() {
        return mActivity;
    }

    @Provides
    @Singleton
    UiNavigator provideUiNavigator(VkManager vkManager, Storage storage) {
        return new UiNavigator(mActivity, vkManager, storage);
    }

    @Provides
    @Singleton
    BackPressedDispatcher provideBackPressedDispatcher() {
        return new BackPressedDispatcher(mActivity);
    }

    @Provides
    PresenterFactory provideChatPresenter(VkManager vkManager, VkRequestsFactory vkRequestsFactory,
                                          QueryFactory queryFactory) {
        return new PresenterFactory(vkManager, vkRequestsFactory, queryFactory);
    }

    @Provides
    ChatsListPresenter provideChatsListPresenter(VkManager vkManager, VkRequestsFactory factory,
                                                 UiNavigator uiNavigator) {
        return new ChatsListPresenter(vkManager, factory, uiNavigator);
    }

    @Provides
    LoginPresenter provideLoginPresenter(UiNavigator uiNavigator) {
        return new LoginPresenter(uiNavigator);
    }

}
