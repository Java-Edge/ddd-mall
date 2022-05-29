/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.mall4j.springboot.starter.cache;

import javax.validation.constraints.NotBlank;

/**
 * 分布式缓存
 */
public interface DistributedCache extends Cache {
    
    /**
     * 放入缓存，自定义超时时间
     *
     * @param key
     * @param value
     * @param timeout
     */
    void put(@NotBlank(message = "缓存 Key 不能为空") String key, Object value, long timeout);
}