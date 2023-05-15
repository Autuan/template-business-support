package top.autuan.templatebusinesssupport.notice.service.impl;

import lombok.extern.slf4j.Slf4j;

import javax.websocket.Session;
import java.io.IOException;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * websocket 客户端用户集
 *
 * @author ruoyi
 */
@Slf4j
public class ManagerMessageWebSocketUsers {

    /**
     * 用户集
     */
    private static Map<String, Session> USERS = new ConcurrentHashMap<>();
    private static Map<String, String> sessionUserMap = new ConcurrentHashMap<>();

    /**
     * 存储用户
     *
     * @param key     唯一键
     * @param session 用户信息
     */
    public static void put(String key, Session session) {
        String sessionId = session.getId();
        sessionUserMap.put(sessionId, key);
        USERS.put(key, session);
    }

    /**
     * 移除用户
     * todo 未维护 sessionUserMap
     * @param session 用户信息
     * @return 移除结果
     */

    public static boolean remove(Session session) {
        String key = null;
        boolean flag = USERS.containsValue(session);
        if (flag) {
            Set<Map.Entry<String, Session>> entries = USERS.entrySet();
            for (Map.Entry<String, Session> entry : entries) {
                Session value = entry.getValue();
                if (value.equals(session)) {
                    key = entry.getKey();
                    break;
                }
            }
        } else {
            return true;
        }
        return remove(key);
    }

    /**
     * 移出用户
     *
     * @param sessionId 键
     */
    public static boolean remove(String sessionId) {
        String key = sessionUserMap.get(sessionId);
        Session remove = USERS.remove(key);
        if (remove != null) {
            boolean containsValue = USERS.containsValue(remove);
            sessionUserMap.remove(sessionId);
            return containsValue;
        } else {
            return true;
        }
    }

    /**
     * 获取在线用户列表
     *
     * @return 返回用户集合
     */
    public static Map<String, Session> getUsers() {
        return USERS;
    }

    /**
     * 群发消息文本消息
     *
     * @param message 消息内容
     */
    @Deprecated
    public static void broadcast(String message) {
        Collection<Session> values = USERS.values();
        for (Session value : values) {
            sendMessageToUserByText(value, message);
        }
    }

    public static void sendMessage(String username, String message) {
        sendMessageToUserByText(USERS.get(username), message);
    }

    /**
     * 发送文本消息
     *
     * @param session session
     * @param message  消息内容
     */
    public static void sendMessageToUserByText(Session session, String message) {
        if (session != null) {
            try {
                session.getBasicRemote().sendText(message);
            } catch (IOException e) {
                log.info("ManagerMessageWebSocketUsers -> sendMessageToUserByText -> IOException -> sessionId -> {} e -> {}",
                        session.getId(),e);
            }
        } else {
            log.info("ManagerMessageWebSocketUsers -> sendMessageToUserByText -> session offline -> sessionId -> {} ",
                    session.getId());
        }
    }
}
