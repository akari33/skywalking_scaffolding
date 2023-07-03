package com.gn.test1;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.theokanning.openai.client.OpenAiApi;
import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatMessage;
import com.theokanning.openai.completion.chat.ChatMessageRole;
import com.theokanning.openai.service.OpenAiService;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static com.theokanning.openai.service.OpenAiService.*;

public class OpenApiTest {

    private static final String TOKEN = "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";

    public static void main(String[] args) {
        //proxy
        ObjectMapper mapper = defaultObjectMapper();
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("127.0.0.1", 7890));
        Duration timeout = Duration.ofSeconds(30);
        OkHttpClient client = defaultClient(TOKEN, timeout)
                .newBuilder()
                .proxy(proxy)
                .build();
        Retrofit retrofit = defaultRetrofit(client, mapper);
        OpenAiApi api = retrofit.create(OpenAiApi.class);
        //open ai
        OpenAiService service = new OpenAiService(api);
        //======================================================================
//        OpenAiService service = new OpenAiService(TOKEN);
//        System.setProperty("proxyHost", "127.0.0.1");
//        System.setProperty("proxyPort", "7890");
        List<ChatMessage> messages = new ArrayList<>();
        ChatMessage userMessage = new ChatMessage(ChatMessageRole.USER.value(), "生成一个java开发简历");
        messages.add(userMessage);
        ChatCompletionRequest completionRequest = ChatCompletionRequest
                .builder()
                .model("gpt-3.5-turbo-0613")
                .messages(messages)
                .build();
        service.createChatCompletion(completionRequest).getChoices().forEach(System.out::println);
    }
}
