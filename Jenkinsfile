#!/usr/bin/env groovy

pipeline {
  agent any
  
  parameters {
        stringnParam(defaultValue: 'cisco_tesla_bx', description: '', name: 'BOX_NAME')
        stringnParam(defaultValue: 'cisco_tesla_bx_v2.3', description: '', name: 'BOX_BRANCH')
        stringnParam(defaultValue: 'rlinux_913', description: '', name: 'CORE_BRANCH')
        stringnParam(defaultValue: 'build_800', description: '', name: 'MTS_BUILD_SYSTEM_BRANCH')
        stringnParam(defaultValue: 'rest_api_800', description: '', name: 'REST_API_BRANCH')
    
        stringnParam(defaultValue: 'box', description: '', name: 'BUILD_TYPE')
        stringnParam(defaultValue: '10.5.231.5:2016', description: '', name: 'DUT_ip_address1')
        stringnParam(defaultValue: '10.5.231.2', description: '', name: 'TFTP_ip_address')
        stringnParam(defaultValue: '--internal-version', description: '', name: 'INTERNAL')
        stringnParam(defaultValue: '10.5.231.5:2014', description: '', name: 'DUT_ip_address2')
    
        stringnParam(defaultValue: '10.5.231.5:2015', description: '', name: 'DUT_ip_address3')
        stringnParam(defaultValue: '10.5.231.5:2009', description: '', name: 'DUT_ip_address4')
        stringnParam(defaultValue: 'sna_gui_tesla_v2.3', description: '', name: 'SNA_GUI_BRANCH')
        stringnParam(defaultValue: 'sna_web_v2.3', description: '', name: 'SNA_WEB_BRANCH')
        stringnParam(defaultValue: 'wb_core_gui_01', description: '', name: 'WEB_CORE_GUI_BRANCH')
    
        stringnParam(defaultValue: 'cisco_tesla_web', description: '', name: 'BX_WEB_NAME')
        stringnParam(defaultValue: 'cisco_tesla_wb_v2.3', description: '', name: 'BX_WEB_BRANCH')
        stringnParam(defaultValue: 'YES', description: '', name: 'Tests_Are_Needed')
        stringnParam(defaultValue: 'yes', description: '', name: 'Webs_are_separated')
    
    }
  
  stages {
    stage('Build') { 
      steps{
        script{
          def mts = new com.marvell.ciutils.MtsUtils(this)
          mts.startBuild()
        }
      }
    }

    stage('Test') {
      steps{
       echo 'MTS Test'
      }
    }

    stage('Deploy') {
      steps{
        echo 'MTS Deploy'
      }
    }
  }
}
