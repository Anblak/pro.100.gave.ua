package ua.game.pro.serviceImpl;

import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.game.pro.entity.FileUser;
import ua.game.pro.service.ESService;
import ua.game.pro.service.FileUserService;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class ESController implements ESService {

    @Autowired
    private FileUserService fileUserService;

    private TransportClient client;

    public ESController() throws UnknownHostException {
        Settings settings = Settings.builder().put("cluster.name", "elasticsearch").build();
        client = new PreBuiltTransportClient(settings)
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("localhost"), 9300));
    }

    public List<FileUser> findFiles(String searchText, Integer groupId) {
        List<Integer> ids = new ArrayList<>();
        List<FileUser> fileUsers = new ArrayList<>();
        String[] includeFields = new String[]{"id"};
        String[] excludeFields = new String[]{"_type"};

        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.query(QueryBuilders.matchQuery("text", searchText));
        sourceBuilder.from(0);
        sourceBuilder.postFilter(QueryBuilders.matchQuery("groupId", groupId));
        sourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));
        sourceBuilder.fetchSource(includeFields, excludeFields);

        SearchRequest searchRequest = new SearchRequest("my_index");
        searchRequest.source(sourceBuilder);

        SearchResponse searchResponse = client.search(searchRequest).actionGet();

        Arrays.stream(searchResponse.getHits().getHits()).forEach(searchHitFields ->
                searchHitFields.getSource().forEach((s, o) -> {
                    fileUsers.add(fileUserService.findOne((int) o));
                })
        );
        return fileUsers;
    }
}
