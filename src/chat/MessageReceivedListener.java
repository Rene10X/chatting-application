package chat;

public interface MessageReceivedListener {
    void onMessageReceived(String message, int position);
}
