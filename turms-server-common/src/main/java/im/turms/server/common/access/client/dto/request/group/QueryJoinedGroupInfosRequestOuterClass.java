/*
 * Copyright (C) 2019 The Turms Project
 * https://github.com/turms-im/turms
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package im.turms.server.common.access.client.dto.request.group;

public final class QueryJoinedGroupInfosRequestOuterClass {
    private QueryJoinedGroupInfosRequestOuterClass() {
    }

    static {
        com.google.protobuf.RuntimeVersion.validateProtobufGencodeVersion(
                com.google.protobuf.RuntimeVersion.RuntimeDomain.PUBLIC,
                /* major= */ 4,
                /* minor= */ 26,
                /* patch= */ 1,
                /* suffix= */ "",
                QueryJoinedGroupInfosRequestOuterClass.class.getName());
    }

    public static void registerAllExtensions(com.google.protobuf.ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(com.google.protobuf.ExtensionRegistry registry) {
        registerAllExtensions((com.google.protobuf.ExtensionRegistryLite) registry);
    }

    static final com.google.protobuf.Descriptors.Descriptor internal_static_im_turms_proto_QueryJoinedGroupInfosRequest_descriptor;
    static final com.google.protobuf.GeneratedMessage.FieldAccessorTable internal_static_im_turms_proto_QueryJoinedGroupInfosRequest_fieldAccessorTable;

    public static com.google.protobuf.Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    private static com.google.protobuf.Descriptors.FileDescriptor descriptor;
    static {
        java.lang.String[] descriptorData = {"\n4request/group/query_joined_group_infos"
                + "_request.proto\022\016im.turms.proto\"T\n\034QueryJ"
                + "oinedGroupInfosRequest\022\036\n\021last_updated_d"
                + "ate\030\001 \001(\003H\000\210\001\001B\024\n\022_last_updated_dateB=\n6"
                + "im.turms.server.common.access.client.dto"
                + ".request.groupP\001\272\002\000b\006proto3"};
        descriptor = com.google.protobuf.Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(
                descriptorData,
                new com.google.protobuf.Descriptors.FileDescriptor[]{});
        internal_static_im_turms_proto_QueryJoinedGroupInfosRequest_descriptor =
                getDescriptor().getMessageTypes()
                        .get(0);
        internal_static_im_turms_proto_QueryJoinedGroupInfosRequest_fieldAccessorTable =
                new com.google.protobuf.GeneratedMessage.FieldAccessorTable(
                        internal_static_im_turms_proto_QueryJoinedGroupInfosRequest_descriptor,
                        new java.lang.String[]{"LastUpdatedDate",});
        descriptor.resolveAllFeaturesImmutable();
    }

    // @@protoc_insertion_point(outer_class_scope)
}
