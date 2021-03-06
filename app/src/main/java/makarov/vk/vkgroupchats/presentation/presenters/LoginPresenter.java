package makarov.vk.vkgroupchats.presentation.presenters;

import javax.inject.Inject;

import makarov.vk.vkgroupchats.mvp.BasePresenter;
import makarov.vk.vkgroupchats.presentation.UiNavigator;
import makarov.vk.vkgroupchats.presentation.view.LoginView;

public class LoginPresenter extends BasePresenter<LoginView> {

    private final UiNavigator mUiNavigator;

    @Inject
    public LoginPresenter(UiNavigator uiNavigator) {
        mUiNavigator = uiNavigator;
    }

    public void login() {
        mUiNavigator.login();
    }
}
