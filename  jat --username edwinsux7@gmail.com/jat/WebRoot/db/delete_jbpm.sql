DELETE FROM jbpm4_deployment;
DELETE FROM jbpm4_deployprop;
UPDATE jbpm4_execution SET INSTANCE_ = NULL;
DELETE FROM jbpm4_execution;
DELETE FROM jbpm4_hist_actinst;
DELETE FROM jbpm4_hist_procinst;
DELETE FROM jbpm4_hist_task;
DELETE FROM jbpm4_hist_var;
DELETE FROM jbpm4_id_group;
DELETE FROM jbpm4_id_membership;
DELETE FROM jbpm4_id_user;
DELETE FROM jbpm4_job;
DELETE FROM jbpm4_lob;
DELETE FROM jbpm4_participation;
DELETE FROM jbpm4_property;
DELETE FROM jbpm4_swimlane;
DELETE FROM jbpm4_task;
DELETE FROM jbpm4_variable;
DELETE FROM leaved;


