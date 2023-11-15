package com.my.app.graphqls;


import com.my.app.graphql.gen.DgsConstants;
import com.my.app.graphql.gen.types.GCUserService;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import graphql.schema.DataFetchingEnvironment;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

@DgsComponent
public class UserServiceImpl {
    @DgsQuery(field = DgsConstants.QUERY.GetGCUserService)
    public CompletableFuture<GCUserService> GetGCUserService(DataFetchingEnvironment dataFetchingEnvironment) {
        return CompletableFuture.supplyAsync(new Supplier<GCUserService>() {
            @Override
            public GCUserService get() {
                return GCUserService.newBuilder()
                        .name("用户服务")
                        .build();
            }
        });
    }
}
