# -*- coding: utf-8 -*-
# Generated by the protocol buffer compiler.  DO NOT EDIT!
# source: recommender.proto
"""Generated protocol buffer code."""
from google.protobuf import descriptor as _descriptor
from google.protobuf import descriptor_pool as _descriptor_pool
from google.protobuf import symbol_database as _symbol_database
from google.protobuf.internal import builder as _builder
# @@protoc_insertion_point(imports)

_sym_db = _symbol_database.Default()




DESCRIPTOR = _descriptor_pool.Default().AddSerializedFile(b'\n\x11recommender.proto\x12\x0brecommender\"\x90\x01\n\x15RecommendationRequest\x12\x0f\n\x07user_id\x18\x01 \x01(\t\x12\x32\n\x0erequester_type\x18\x02 \x01(\x0e\x32\x1a.recommender.RequesterType\x12\x32\n\x0erequested_type\x18\x03 \x01(\x0e\x32\x1a.recommender.RequestedType\"3\n\x16RecommendationResponse\x12\x19\n\x11recommended_items\x18\x01 \x03(\t*i\n\rRequesterType\x12\x15\n\x11REQUESTER_UNKNOWN\x10\x00\x12\x15\n\x11REQUESTER_COMPANY\x10\x01\x12\x11\n\rREQUESTER_NGO\x10\x02\x12\x17\n\x13REQUESTER_VOLUNTEER\x10\x03*i\n\rRequestedType\x12\x15\n\x11REQUESTED_UNKNOWN\x10\x00\x12\x15\n\x11REQUESTED_COMPANY\x10\x01\x12\x11\n\rREQUESTED_NGO\x10\x02\x12\x17\n\x13REQUESTED_VOLUNTEER\x10\x03\x32l\n\x0bRecommender\x12]\n\x12GetRecommendations\x12\".recommender.RecommendationRequest\x1a#.recommender.RecommendationResponseb\x06proto3')

_globals = globals()
_builder.BuildMessageAndEnumDescriptors(DESCRIPTOR, _globals)
_builder.BuildTopDescriptorsAndMessages(DESCRIPTOR, 'recommender_pb2', _globals)
if _descriptor._USE_C_DESCRIPTORS == False:

  DESCRIPTOR._options = None
  _globals['_REQUESTERTYPE']._serialized_start=234
  _globals['_REQUESTERTYPE']._serialized_end=339
  _globals['_REQUESTEDTYPE']._serialized_start=341
  _globals['_REQUESTEDTYPE']._serialized_end=446
  _globals['_RECOMMENDATIONREQUEST']._serialized_start=35
  _globals['_RECOMMENDATIONREQUEST']._serialized_end=179
  _globals['_RECOMMENDATIONRESPONSE']._serialized_start=181
  _globals['_RECOMMENDATIONRESPONSE']._serialized_end=232
  _globals['_RECOMMENDER']._serialized_start=448
  _globals['_RECOMMENDER']._serialized_end=556
# @@protoc_insertion_point(module_scope)
