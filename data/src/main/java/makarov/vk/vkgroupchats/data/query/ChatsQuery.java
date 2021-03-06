package makarov.vk.vkgroupchats.data.query;

import makarov.vk.vkgroupchats.data.Storage;
import makarov.vk.vkgroupchats.data.models.Chat;

public class ChatsQuery extends RealmBaseQuery<Chat> {

    public ChatsQuery(Storage realmStorage) {
        super(realmStorage, Chat.class);
    }

    public Chat findById(int chatId) {
        mRealmQuery.equalTo("chatId", chatId);
        return mRealmQuery.findFirst();
    }

}