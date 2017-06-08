/**
 * Copyright � 2017 DELL Inc. or its subsidiaries.  All Rights Reserved.
 */
package com.dell.isg.smi.service.server.inventory.Transformer;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dell.isg.smi.adapter.server.model.HardwareInventory;
import com.dell.isg.smi.adapter.server.model.HeadRoom;
import com.dell.isg.smi.adapter.server.model.PowerMonitoring;
import com.dell.isg.smi.adapter.server.model.PowerStatistics;
import com.dell.isg.smi.adapter.server.model.Storage;
import com.dell.isg.smi.commons.utilities.datetime.DateTimeUtils;
import com.dell.isg.smi.commons.model.manager.IdracCardString;
import com.dell.isg.smi.commons.model.server.inventory.HwBattery;
import com.dell.isg.smi.commons.model.server.inventory.HwController;
import com.dell.isg.smi.commons.model.server.inventory.HwCpu;
import com.dell.isg.smi.commons.model.server.inventory.HwEnclosure;
import com.dell.isg.smi.commons.model.server.inventory.HwFan;
import com.dell.isg.smi.commons.model.server.inventory.HwMemory;
import com.dell.isg.smi.commons.model.server.inventory.HwNic;
import com.dell.isg.smi.commons.model.server.inventory.HwPhysicalDisk;
import com.dell.isg.smi.commons.model.server.inventory.HwPowerMonitoring;
import com.dell.isg.smi.commons.model.server.inventory.HwPsu;
import com.dell.isg.smi.commons.model.server.inventory.HwSDCard;
import com.dell.isg.smi.commons.model.server.inventory.HwStorage;
import com.dell.isg.smi.commons.model.server.inventory.HwSystem;
import com.dell.isg.smi.commons.model.server.inventory.HwTemperature;
import com.dell.isg.smi.commons.model.server.inventory.HwVirtualDisk;
import com.dell.isg.smi.commons.model.server.inventory.HwVoltage;
import com.dell.isg.smi.commons.model.server.inventory.ServerHardwareInventory;
import com.dell.isg.smi.service.server.inventory.utilities.PatternUtils;
import com.dell.isg.smi.wsman.command.entity.CPUView;
import com.dell.isg.smi.wsman.command.entity.ControllerView;
import com.dell.isg.smi.wsman.command.entity.DCIMNICViewType;
import com.dell.isg.smi.wsman.command.entity.DCIMSystemViewType;
import com.dell.isg.smi.wsman.command.entity.EnclosureView;
import com.dell.isg.smi.wsman.command.entity.FanView;
import com.dell.isg.smi.wsman.command.entity.IDRACCardStringView;
import com.dell.isg.smi.wsman.command.entity.MemoryView;
import com.dell.isg.smi.wsman.command.entity.NumericSensorView;
import com.dell.isg.smi.wsman.command.entity.PhysicalDiskView;
import com.dell.isg.smi.wsman.command.entity.PowerSupplyView;
import com.dell.isg.smi.wsman.command.entity.SensorView;
import com.dell.isg.smi.wsman.command.entity.VFlashView;
import com.dell.isg.smi.wsman.command.entity.VirtualDiskView;

public class TranformerUtil {

    private final static Logger logger = LoggerFactory.getLogger(TranformerUtil.class.getName());


    public static ServerHardwareInventory transformHardwareInventory(HardwareInventory hardwareInventory, ServerHardwareInventory serverHardwareInventory) throws Exception {
        if (hardwareInventory == null) {
            return serverHardwareInventory;
        }
        serverHardwareInventory.setSystem(transformHwSystem(hardwareInventory.getSystem()));
        serverHardwareInventory.getBatteries().addAll(transformBattery(hardwareInventory.getBatteryView()));
        serverHardwareInventory.getMemories().addAll(transformHwMemory(hardwareInventory.getMemoryView()));
        serverHardwareInventory.getNics().addAll(transformHwNic(hardwareInventory.getNicView()));
        serverHardwareInventory.getPowerSupplyUnits().addAll(transformHwPowerSupply(hardwareInventory.getPowerSupplyView()));
        serverHardwareInventory.getFans().addAll(transformHwFans(hardwareInventory.getFanView()));
        serverHardwareInventory.getCpus().addAll(transformHwCpus(hardwareInventory.getCpuView()));
        serverHardwareInventory.getSdCards().addAll(transformSdCards(hardwareInventory.getRemovableMedia()));
        serverHardwareInventory.setStorage(transformStorage(hardwareInventory.getStorage()));
        serverHardwareInventory.getVoltages().addAll(transformVoltage(hardwareInventory.getVoltageView()));
        serverHardwareInventory.getTemperatures().addAll(transformTemperatures(hardwareInventory.getTemperatureView()));
        serverHardwareInventory.setPowerMonitoring(transformPowerMonitor(hardwareInventory.getPowerMonitoring()));
        return serverHardwareInventory;
    }


    private static HwStorage transformStorage(final Storage storage) throws ParseException {
        HwStorage hwStorage = new HwStorage();
        if (storage == null) {
            return hwStorage;
        }
        if (storage.getControllers() != null) {
            hwStorage.getControllers().addAll(transformController(storage.getControllers()));
        }
        if (storage.getEnclosures() != null) {
            hwStorage.getEnclosures().addAll(transformEnclosure(storage.getEnclosures()));
        }
        if (storage.getPhysicalDisks() != null) {
            hwStorage.getPhysicalDisks().addAll(transformPhysicalDisk(storage.getPhysicalDisks()));
        }
        if (storage.getVirtualDisks() != null) {
            hwStorage.getVirtualDisks().addAll(transformVirtualDisk(storage.getVirtualDisks()));
        }
        return hwStorage;
    }


    private static List<HwController> transformController(final List<ControllerView> controllerViewList) {
        List<HwController> hwControllerList = new ArrayList<HwController>();
        if (CollectionUtils.isEmpty(controllerViewList)) {
            return hwControllerList;
        }
        for (ControllerView controllerView : controllerViewList) {
            HwController hwController = new HwController();
            hwController.setBus(controllerView.getBus());
            hwController.setCacheSizeInMB(controllerView.getCacheSizeInMB());
            hwController.setCacheCadeCapability(controllerView.getCacheCadeCapability());
            hwController.setControllerFirmwareVersion(controllerView.getControllerFirmwareVersion());
            hwController.setDevice(controllerView.getDevice());
            hwController.setDeviceCardDataBusWidth(controllerView.getDeviceCardDataBusWidth());
            hwController.setDeviceCardManufacturer(controllerView.getDeviceCardManufacturer());
            hwController.setDeviceCardSlotLength(controllerView.getDeviceCardSlotLength());
            hwController.setDeviceCardSlotType(controllerView.getDeviceCardSlotType());
            hwController.setDeviceDescription(controllerView.getDeviceDescription());
            hwController.setDriverVersion(controllerView.getDriverVersion());
            hwController.setEncryptionCapability(controllerView.getEncryptionCapability());
            hwController.setEncryptionMode(controllerView.getEncryptionMode());
            hwController.setfQDD(controllerView.getfQDD());
            hwController.setFunction(controllerView.getFunction());
            hwController.setInstanceID(controllerView.getInstanceID());
            hwController.setKeyID(controllerView.getKeyID());
            hwController.setLastSystemInventoryTime(controllerView.getLastSystemInventoryTime());
            hwController.setLastUpdateTime(controllerView.getLastUpdateTime());
            hwController.setMaxAvailablePciLinkSpeed(controllerView.getMaxAvailablePciLinkSpeed());
            hwController.setMaxPossiblePciLinkSpeed(controllerView.getMaxPossiblePciLinkSpeed());
            hwController.setPCIDeviceID(controllerView.getPCIDeviceID());
            hwController.setPCISlot(controllerView.getPCISlot());
            hwController.setPCISubDeviceID(controllerView.getPCISubDeviceID());
            hwController.setPCISubVendorID(controllerView.getPCISubVendorID());
            hwController.setPCIVendorID(controllerView.getPCIVendorID());
            hwController.setPatrolReadState(controllerView.getPatrolReadState());
            hwController.setPrimaryStatus(controllerView.getPrimaryStatus());
            hwController.setProductName(controllerView.getProductName());
            hwController.setRealtimeCapability(controllerView.getRealtimeCapability());
            hwController.setRollUpStatus(controllerView.getRollUpStatus());
            hwController.setSASAddress(controllerView.getSASAddress());
            hwController.setSecurityStatus(controllerView.getSecurityStatus());
            hwController.setSlicedVDCapability(controllerView.getSlicedVDCapability());
            hwController.setSupportControllerBootMode(controllerView.getSupportControllerBootMode());
            hwController.setSupportEnhancedAutoForeignImport(controllerView.getSupportEnhancedAutoForeignImport());
            hwController.setSupportRaid10UnevenSpans(controllerView.getSupportRaid10UnevenSpans());
            hwController.setT10piCapability(controllerView.getT10piCapability());
            hwController.setPossibleSpeed(controllerView.getPossibleSpeed());
            hwController.setPatrolReadMode(controllerView.getPatrolReadMode());
            hwController.setCcMode(controllerView.getCcMode());
            hwController.setCcRate(controllerView.getCcRate());
            hwController.setCopyBackMode(controllerView.getCopyBackMode());
            hwController.setBgiRate(controllerView.getBgiRate());
            hwController.setRebuildRate(controllerView.getRebuildRate());
            hwController.setBatteryState(controllerView.getBatteryState());
            hwController.setPreservedCache(controllerView.getCacheCadeCapability());
            hwController.setBatteryStatus(controllerView.getBatteryStatus());
            hwControllerList.add(hwController);
        }
        return hwControllerList;
    }


    private static List<HwEnclosure> transformEnclosure(final List<EnclosureView> enclosureViewList) throws ParseException {
        List<HwEnclosure> hwenclosureList = new ArrayList<HwEnclosure>();
        if (CollectionUtils.isEmpty(enclosureViewList)) {
            return hwenclosureList;
        }
        for (EnclosureView enclosureView : enclosureViewList) {
            HwEnclosure hwEnclosure = new HwEnclosure();
            hwEnclosure.setFqdd(enclosureView.getfQDD());
            hwEnclosure.setAssetTag(enclosureView.getAssetTag());
            hwEnclosure.setConnector(enclosureView.getConnector());
            hwEnclosure.setEmmCount(NumberUtils.toInt(enclosureView.geteMMCount()));
            hwEnclosure.setFanCount(NumberUtils.toInt(enclosureView.getFanCount()));
            hwEnclosure.setInstanceId(enclosureView.getInstanceID());
            hwEnclosure.setLastSystemInventoryTime(getIsoDateString(enclosureView.getLastSystemInventoryTime(), TransformerAssemblerConstants.ENCLOSURE_DATE_FORMAT));
            hwEnclosure.setLastUpdateTime(getIsoDateString(enclosureView.getLastUpdateTime(), TransformerAssemblerConstants.ENCLOSURE_DATE_FORMAT));
            hwEnclosure.setPrimaryStatus(enclosureView.getPrimaryStatus());
            hwEnclosure.setProductName(enclosureView.getProductName());
            hwEnclosure.setPsuCount(NumberUtils.toInt(enclosureView.getpSUCount()));
            hwEnclosure.setRollupStatus(enclosureView.getRollupStatus());
            hwEnclosure.setSlotCount(NumberUtils.toInt(enclosureView.getSlotCount()));
            hwEnclosure.setTempProbeCount(NumberUtils.toInt(enclosureView.getTempProbeCount()));
            hwEnclosure.setServiceTag(enclosureView.getServiceTag());
            hwEnclosure.setVersion(enclosureView.getVersion());
            hwEnclosure.setWiredOrder(enclosureView.getWiredOrder());
            hwEnclosure.setDeviceDescription(enclosureView.getDeviceDescription());
            hwEnclosure.setState(enclosureView.getState());
            hwenclosureList.add(hwEnclosure);
        }
        return hwenclosureList;
    }


    private static List<HwVirtualDisk> transformVirtualDisk(final List<VirtualDiskView> virtualDiskViewList) {
        List<HwVirtualDisk> hWVirtualDiskList = new ArrayList<HwVirtualDisk>();
        if (CollectionUtils.isEmpty(virtualDiskViewList)) {
            return hWVirtualDiskList;
        }
        for (VirtualDiskView virtualDiskView : virtualDiskViewList) {
            HwVirtualDisk hwVirtualDisk = new HwVirtualDisk();
            hwVirtualDisk.setFqdd(virtualDiskView.getfQDD());
            hwVirtualDisk.setBusProtocol(virtualDiskView.getBusProtocol());
            hwVirtualDisk.setLockStatus(virtualDiskView.getLockStatus());
            hwVirtualDisk.setMediaType(virtualDiskView.getMediaType());
            hwVirtualDisk.setName(virtualDiskView.getName());
            hwVirtualDisk.setObjectStatus(virtualDiskView.getObjectStatus());
            hwVirtualDisk.setPrimaryStatus(virtualDiskView.getPrimaryStatus());
            hwVirtualDisk.setRaidStatus(virtualDiskView.getRaidStatus());
            hwVirtualDisk.setRaidTypes(virtualDiskView.getRaidTypes());
            hwVirtualDisk.setReadCachePolicy(virtualDiskView.getReadCachePolicy());
            hwVirtualDisk.setRemainingRedundancy(virtualDiskView.getRemainingRedundancy());
            hwVirtualDisk.setSizeInBytes(virtualDiskView.getSizeInBytes());
            hwVirtualDisk.setSpanDepth(virtualDiskView.getSpanDepth());
            hwVirtualDisk.setSpanLength(virtualDiskView.getSpanLength());
            hwVirtualDisk.setStartingLbaInBlocks(virtualDiskView.getStartingLBAInBlocks());
            hwVirtualDisk.setStripeSize(virtualDiskView.getStripeSize());
            hwVirtualDisk.setVirtualDiskTargetId(virtualDiskView.getVirtualDiskTargetID());
            hwVirtualDisk.setWriteCachePolicy(virtualDiskView.getWriteCachePolicy());
            hwVirtualDisk.setDiskCachePolicy(virtualDiskView.getDiskCachePolicy());
            hwVirtualDisk.setCacheCade(virtualDiskView.getCacheCade());
            hwVirtualDisk.setDeviceDescription(virtualDiskView.getDeviceDescription());
            hwVirtualDisk.setT10piStatus(virtualDiskView.getT10piStatus());
            hwVirtualDisk.setBlockSizeInBytes(virtualDiskView.getBlockSizeInBytes());
            hwVirtualDisk.setOperationName(virtualDiskView.getOperationName());
            hwVirtualDisk.setOperationPercentComplete(virtualDiskView.getOperationPercentComplete());
            hwVirtualDisk.setPendingOperations(virtualDiskView.getPendingOperations());
            hwVirtualDisk.setRollupStatus(virtualDiskView.getRollupStatus());
            hwVirtualDisk.setInstanceId(virtualDiskView.getInstanceID());
            hwVirtualDisk.setLastSystemInventoryTime(virtualDiskView.getLastSystemInventoryTime());
            hwVirtualDisk.setLastUpdateTime(virtualDiskView.getLastUpdateTime());
            hwVirtualDisk.setPhysicalDiskIds(virtualDiskView.getPhysicalDiskIDs());
            hWVirtualDiskList.add(hwVirtualDisk);
        }
        return hWVirtualDiskList;
    }


    private static List<HwPhysicalDisk> transformPhysicalDisk(final List<PhysicalDiskView> physicalDiskViewList) {
        List<HwPhysicalDisk> hwPhysicalDiskList = new ArrayList<HwPhysicalDisk>();
        if (CollectionUtils.isEmpty(physicalDiskViewList)) {
            return hwPhysicalDiskList;
        }
        HwPhysicalDisk hwPhysicalDisk;
        for (PhysicalDiskView physicaldiskview : physicalDiskViewList) {
            hwPhysicalDisk = new HwPhysicalDisk();
            hwPhysicalDisk.setBlockSizeInBytes(physicaldiskview.getBlockSizeInBytes());
            hwPhysicalDisk.setBusProtocol(physicaldiskview.getBusProtocol());
            hwPhysicalDisk.setConnector(physicaldiskview.getConnector());
            hwPhysicalDisk.setDeviceDescription(physicaldiskview.getDeviceDescription());
            hwPhysicalDisk.setDriveFormFactor(physicaldiskview.getDriveFormFactor());
            hwPhysicalDisk.setFQDD(physicaldiskview.getfQDD());
            hwPhysicalDisk.setFreeSizeInBytes(physicaldiskview.getFreeSizeInBytes());
            hwPhysicalDisk.setHotSpareStatus(physicaldiskview.getHotSpareStatus());
            hwPhysicalDisk.setInstanceID(physicaldiskview.getInstanceID());
            hwPhysicalDisk.setLastSystemInventoryTime(physicaldiskview.getLastSystemInventoryTime());
            hwPhysicalDisk.setLastUpdateTime(physicaldiskview.getLastUpdateTime());
            hwPhysicalDisk.setManufacturer(physicaldiskview.getManufacturer());
            hwPhysicalDisk.setManufacturingDay(physicaldiskview.getManufacturingDay());
            hwPhysicalDisk.setManufacturingWeek(physicaldiskview.getManufacturingWeek());
            hwPhysicalDisk.setManufacturingYear(physicaldiskview.getManufacturingYear());
            hwPhysicalDisk.setMaxCapableSpeed(physicaldiskview.getMaxCapableSpeed());
            hwPhysicalDisk.setMediaType(physicaldiskview.getMediaType());
            hwPhysicalDisk.setModel(physicaldiskview.getModel());
            hwPhysicalDisk.setOperationName(physicaldiskview.getOperationName());
            hwPhysicalDisk.setOperationPercentComplete(physicaldiskview.getOperationPercentComplete());
            hwPhysicalDisk.setPPID(physicaldiskview.getPPID());
            hwPhysicalDisk.setPredictiveFailureState(physicaldiskview.getPredictiveFailureState());
            hwPhysicalDisk.setPrimaryStatus(physicaldiskview.getPrimaryStatus());
            hwPhysicalDisk.setRaidStatus(physicaldiskview.getRaidStatus());
            hwPhysicalDisk.setRemainingRatedWriteEndurance(physicaldiskview.getRemainingRatedWriteEndurance());
            hwPhysicalDisk.setRevision(physicaldiskview.getRevision());
            hwPhysicalDisk.setRollupStatus(physicaldiskview.getRollUpStatus());
            hwPhysicalDisk.setSASAddress(physicaldiskview.getSASAddress());
            hwPhysicalDisk.setSecurityState(physicaldiskview.getSecurityState());
            hwPhysicalDisk.setSerialNumber(physicaldiskview.getSerialNumber());
            hwPhysicalDisk.setSizeInBytes(physicaldiskview.getSizeInBytes());
            hwPhysicalDisk.setSlot(physicaldiskview.getSlot());
            hwPhysicalDisk.setSupportedEncryptionTypes(physicaldiskview.getSupportedEncryptionTypes());
            hwPhysicalDisk.setT10PICapability(physicaldiskview.getT10PICapability());
            hwPhysicalDisk.setUsedSizeInBytes(physicaldiskview.getUsedSizeInBytes());

            hwPhysicalDiskList.add(hwPhysicalDisk);
        }
        return hwPhysicalDiskList;
    }


    private static List<HwBattery> transformBattery(final List<SensorView> batteries) {
        List<HwBattery> hwBatteryList = new ArrayList<HwBattery>();
        if (CollectionUtils.isEmpty(batteries)) {
            return hwBatteryList;
        }
        for (SensorView sensorView : batteries) {
            if (sensorView.isBattery()) {
                HwBattery hwBattery = new HwBattery();
                hwBattery.setProbeName(sensorView.getElementName());
                hwBattery.setState(sensorView.getCurrentState());
                hwBattery.setStatus(sensorView.getPrimaryStatus());
                hwBatteryList.add(hwBattery);
            }
        }
        return hwBatteryList;
    }


    private static List<HwVoltage> transformVoltage(List<SensorView> voltages) {

        List<HwVoltage> hwVoltageList = new ArrayList<HwVoltage>();
        if (CollectionUtils.isEmpty(voltages)) {
            return hwVoltageList;
        }
        for (SensorView sensorView : voltages) {
            if (sensorView.isVoltage()) {
                HwVoltage hwVoltage = new HwVoltage();
                hwVoltage.setProbeName(sensorView.getElementName());
                hwVoltage.setStatus(sensorView.getPrimaryStatus());
                hwVoltage.setReading(sensorView.getCurrentState());
                hwVoltageList.add(hwVoltage);
            }
        }
        return hwVoltageList;
    }


    private static List<HwTemperature> transformTemperatures(List<NumericSensorView> temperatures) {
        List<HwTemperature> hwTemperatureList = new ArrayList<HwTemperature>();
        if (CollectionUtils.isEmpty(temperatures)) {
            return hwTemperatureList;
        }
        for (NumericSensorView sensorView : temperatures) {
            HwTemperature hwTemperature = new HwTemperature();
            hwTemperature.setProbeName(sensorView.getElementName());
            hwTemperature.setStatus(sensorView.getPrimaryStatus());
            hwTemperature.setReading(sensorView.getCurrentReading() + " " + sensorView.getBaseUnits());
            hwTemperature.setMinWarningThreshold(sensorView.getLowerThresholdNonCritical());
            hwTemperature.setMaxWarningThreshold(sensorView.getUpperThresholdNonCritical());
            hwTemperature.setMinCriticalThreshold(sensorView.getLowerThresholdCritical());
            hwTemperature.setMaxCriticalThreshold(sensorView.getUpperThresholdCritical());
            hwTemperatureList.add(hwTemperature);
        }
        return hwTemperatureList;
    }


    private static HwPowerMonitoring transformPowerMonitor(PowerMonitoring powerMonitoring) throws ParseException {

        HwPowerMonitoring hwPowerMonitoring = new HwPowerMonitoring();
        if (powerMonitoring == null) {
            return hwPowerMonitoring;
        }
        hwPowerMonitoring.setPowerCap(powerMonitoring.getPowerCap());
        hwPowerMonitoring.setProfile(powerMonitoring.getProfile());
        hwPowerMonitoring.setWarningThreshold(powerMonitoring.getWarningThreshold());
        hwPowerMonitoring.setFailureThreshold(powerMonitoring.getFailureThreshold());
        hwPowerMonitoring.setProbeName(powerMonitoring.getProbeName());
        hwPowerMonitoring.setCurrentReading(powerMonitoring.getCurrentReading());

        PowerStatistics powerStatistics = powerMonitoring.getPowerStatistics();
        if (powerStatistics != null) {
            hwPowerMonitoring.setEnergyConsumption(powerStatistics.getEnergyConsumption());
            hwPowerMonitoring.setEnergyConsumptionStartDateTime(getIsoDateString(powerStatistics.getEnergyConsumptionStartDateTime(), TransformerAssemblerConstants.POWER_MONITORING_DATE_FORMAT));
            hwPowerMonitoring.setEnergyConsumptionEndDateTime(getIsoDateString(powerStatistics.getEnergyConsumptionEndDateTime(), TransformerAssemblerConstants.POWER_MONITORING_DATE_FORMAT));

            hwPowerMonitoring.setSystemPeakPower(powerStatistics.getSystemPeakPower());
            hwPowerMonitoring.setSystemPeakPowerStartDateTime(getIsoDateString(powerStatistics.getSystemPeakPowerStartDateTime(), TransformerAssemblerConstants.POWER_MONITORING_DATE_FORMAT));
            hwPowerMonitoring.setSystemPeakPowerEndDateTime(getIsoDateString(powerStatistics.getSystemPeakPowerEndDateTime(), TransformerAssemblerConstants.POWER_MONITORING_DATE_FORMAT));

            hwPowerMonitoring.setSystemPeakAmps(powerStatistics.getSystemPeakAmps());
            hwPowerMonitoring.setPeakAmpsStartDateTime(getIsoDateString(powerStatistics.getPeakAmpsStartDateTime(), TransformerAssemblerConstants.POWER_MONITORING_DATE_FORMAT));
            hwPowerMonitoring.setPeakAmpsEndDateTime(getIsoDateString(powerStatistics.getPeakAmpsEndDateTime(), TransformerAssemblerConstants.POWER_MONITORING_DATE_FORMAT));

            hwPowerMonitoring.setLastHourPeakAverage(powerStatistics.getLastHourPeakAverage());
            hwPowerMonitoring.setLastHourPeakTime(getIsoDateString(powerStatistics.getLastHourPeakTime(), TransformerAssemblerConstants.POWER_MONITORING_DATE_FORMAT));
            hwPowerMonitoring.setLastHourPeakMax(powerStatistics.getLastHourPeakMax());
            hwPowerMonitoring.setLastHourPeakMaxTime(getIsoDateString(powerStatistics.getLastHourPeakMaxTime(), TransformerAssemblerConstants.POWER_MONITORING_DATE_FORMAT));
            hwPowerMonitoring.setLastHourPeakMin(powerStatistics.getLastHourPeakMin());
            hwPowerMonitoring.setLastHourPeakMinTime(getIsoDateString(powerStatistics.getLastHourPeakMinTime(), TransformerAssemblerConstants.POWER_MONITORING_DATE_FORMAT));

            hwPowerMonitoring.setLastDayPeakAverage(powerStatistics.getLastDayPeakAverage());
            hwPowerMonitoring.setLastDayPeakTime(getIsoDateString(powerStatistics.getLastDayPeakTime(), TransformerAssemblerConstants.POWER_MONITORING_DATE_FORMAT));
            hwPowerMonitoring.setLastDayPeakMax(powerStatistics.getLastDayPeakMax());
            hwPowerMonitoring.setLastDayPeakMaxTime(getIsoDateString(powerStatistics.getLastDayPeakMaxTime(), TransformerAssemblerConstants.POWER_MONITORING_DATE_FORMAT));
            hwPowerMonitoring.setLastDayPeakMin(powerStatistics.getLastDayPeakMin());
            hwPowerMonitoring.setLastDayPeakMinTime(getIsoDateString(powerStatistics.getLastDayPeakMinTime(), TransformerAssemblerConstants.POWER_MONITORING_DATE_FORMAT));

            hwPowerMonitoring.setLastWeekPeakAverage(powerStatistics.getLastWeekPeakAverage());
            hwPowerMonitoring.setLastWeekPeakTime(getIsoDateString(powerStatistics.getLastWeekPeakTime(), TransformerAssemblerConstants.POWER_MONITORING_DATE_FORMAT));
            hwPowerMonitoring.setLastWeekPeakMax(powerStatistics.getLastWeekPeakMax());
            hwPowerMonitoring.setLastWeekPeakMaxTime(getIsoDateString(powerStatistics.getLastWeekPeakMaxTime(), TransformerAssemblerConstants.POWER_MONITORING_DATE_FORMAT));
            hwPowerMonitoring.setLastWeekPeakMin(powerStatistics.getLastWeekPeakMin());
            hwPowerMonitoring.setLastWeekPeakMinTime(getIsoDateString(powerStatistics.getLastWeekPeakMinTime(), TransformerAssemblerConstants.POWER_MONITORING_DATE_FORMAT));
        }

        HeadRoom headRoom = powerMonitoring.getHeadRoom();
        if (headRoom != null) {
            hwPowerMonitoring.setSystemInstantaneousHeadroom(headRoom.getSystemInstantaneousHeadroom());
            hwPowerMonitoring.setSystemPeakHeadroom(headRoom.getSystemPeakHeadroom());
        }
        return hwPowerMonitoring;
    }

    private static String getIsoDateString(String dateString, String dateFormat) {
        try{
            return DateTimeUtils.getIsoDateString(dateString,  dateFormat );
        }
        catch(Exception e)
        {
            logger.debug("failed to parse string");
            return "";
        }
    }
    
    
    private static String getIsoDateString(String utcDateString, String[] datePatterns){
        try{
            return DateTimeUtils.getIsoDateString(utcDateString,  datePatterns );
        }
        catch(Exception e)
        {
            logger.debug("failed to parse string array");
            return "";
        }
    }
    

    private static List<HwSDCard> transformSdCards(List<VFlashView> vflashViews) {
        List<HwSDCard> hwSdCardList = new ArrayList<HwSDCard>();
        if (CollectionUtils.isEmpty(vflashViews)) {
            return hwSdCardList;
        }
        HwSDCard hwSDCard;
        for (VFlashView vflashView : vflashViews) {
            hwSDCard = new HwSDCard();
            hwSDCard.setComponentName(vflashView.getComponentName());
            hwSDCard.setDeviceDescription(vflashView.getDeviceDescription());
            hwSDCard.setFqdd(vflashView.getFQDD());
            hwSDCard.setInstanceID(vflashView.getInstanceID());
            hwSDCard.setInitializedState(vflashView.getInitializedState());
            hwSDCard.setSize(vflashView.getCapacity());
            hwSDCard.setStatus(vflashView.getHealthStatus());
            hwSDCard.setSpace(vflashView.getAvailableSize());
            hwSDCard.setWriteProctected(vflashView.getWriteProtected());
            hwSDCard.setVFlashEnabled(vflashView.getvFlashEnabledState());
            hwSDCard.setLicensed(vflashView.getLicensed());
            hwSDCard.setLocation("vFlash");
            hwSDCard.setOnlineStatus("Present");
            hwSdCardList.add(hwSDCard);
        }
        return hwSdCardList;
    }


    private static List<HwCpu> transformHwCpus(List<CPUView> cpus) {
        List<HwCpu> hwCpuList = new ArrayList<HwCpu>();
        if (CollectionUtils.isEmpty(cpus)) {
            return hwCpuList;
        }
        HwCpu hwCpu;
        for (CPUView cpuView : cpus) {
            hwCpu = new HwCpu();
            hwCpu.setExternalBusClockSpeed(cpuView.getExternalBusClockSpeed());
            hwCpu.setFqdd(cpuView.getfQDD());
            hwCpu.setManufacturer(cpuView.getManufacturer());
            hwCpu.setMaxClockSpeed(cpuView.getMaxClockSpeed());
            hwCpu.setModel(cpuView.getModel());
            hwCpu.setNumberOfEnabledCores(cpuView.getNumberOfEnabledCores());
            hwCpu.setNumberOfProcessorCores(cpuView.getNumberOfProcessorCores());
            hwCpu.setPrimaryStatus(cpuView.getPrimaryStatus());
            hwCpu.setVoltage(cpuView.getVoltage());
            hwCpu.setCurrentClockSpeed(cpuView.getCurrentClockSpeed());
            hwCpu.setCache1Associativity(cpuView.getCache1Associativity());
            hwCpu.setCache2Associativity(cpuView.getCache2Associativity());
            hwCpu.setCache3Associativity(cpuView.getCache3Associativity());
            hwCpu.setCache1WritePolicy(cpuView.getCache1WritePolicy());
            hwCpu.setCache2WritePolicy(cpuView.getCache2WritePolicy());
            hwCpu.setCache3WritePolicy(cpuView.getCache3WritePolicy());
            hwCpu.setCache1ErrorMethodology(cpuView.getCache1ErrorMethodology());
            hwCpu.setCache2ErrorMethodology(cpuView.getCache2ErrorMethodology());
            hwCpu.setCache3ErrorMethodology(cpuView.getCache3ErrorMethodology());
            hwCpu.setCache1Size(cpuView.getCache1Size());
            hwCpu.setCache2Size(cpuView.getCache2Size());
            hwCpu.setCache3Size(cpuView.getCache3Size());
            hwCpu.setCache1Type(cpuView.getCache1Type());
            hwCpu.setCache2Type(cpuView.getCache2Type());
            hwCpu.setCache3Type(cpuView.getCache3Type());
            hwCpu.setCache1Level(cpuView.getCache1Level());
            hwCpu.setCache2Level(cpuView.getCache2Level());
            hwCpu.setCache3Level(cpuView.getCache3Level());
            hwCpu.setCache1PrimaryStatus(cpuView.getCache1PrimaryStatus());
            hwCpu.setCache2PrimaryStatus(cpuView.getCache2PrimaryStatus());
            hwCpu.setCache3PrimaryStatus(cpuView.getCache3PrimaryStatus());
            hwCpu.setCache1Location(cpuView.getCache1Location());
            hwCpu.setCache2Location(cpuView.getCache2Location());
            hwCpu.setCache3Location(cpuView.getCache3Location());
            hwCpu.setCache1SramType(cpuView.getCache1SramType());
            hwCpu.setCache2SramType(cpuView.getCache2SramType());
            hwCpu.setCache3SramType(cpuView.getCache3SramType());
            hwCpu.setDeviceDescription(cpuView.getDeviceDescription());
            hwCpu.setExecuteDisabledCapable(cpuView.getExecuteDisabledCapable());
            hwCpu.setExecuteDisabledEnabled(cpuView.getExecuteDisabledEnabled());
            hwCpu.setHyperThreadingCapable(cpuView.getHyperThreadingCapable());
            hwCpu.setHyperThreadingEnabled(cpuView.getHyperThreadingEnabled());
            hwCpu.setVirtualizationTechnologyCapable(cpuView.getVirtualizationTechnologyCapable());
            hwCpu.setVirtualizationTechnologyEnabled(cpuView.getVirtualizationTechnologyEnabled());
            hwCpu.setTurboModeCapable(cpuView.getTurboModeCapable());
            hwCpu.setTurboModeEnabled(cpuView.getTurboModeEnabled());
            hwCpu.setCpuFamily(cpuView.getCpuFamily());
            hwCpu.setCpuStatus(cpuView.getCpuStatus());
            hwCpuList.add(hwCpu);
        }
        return hwCpuList;
    }


    private static List<HwFan> transformHwFans(List<FanView> fans) {
        List<HwFan> hwfanList = new ArrayList<HwFan>();
        if (CollectionUtils.isEmpty(fans)) {
            return hwfanList;
        }
        HwFan hwFan;
        for (FanView fan : fans) {
            hwFan = new HwFan();
            hwFan.setActiveCooling(fan.getActiveCooling());
            hwFan.setCurrentReading(fan.getCurrentReading());
            hwFan.setDeviceDescription(fan.getDeviceDescription());
            hwFan.setFqdd(fan.getFQDD());
            hwFan.setPrimaryStatus(fan.getPrimaryStatus());
            hwFan.setPwm(fan.getPwm());
            hwFan.setRedundancyStatus(fan.getRedundancyStatus());
            hwFan.setMinWarningThreshold(fan.getLowerThresholdNonCritical());
            hwFan.setMinCriticalThreshold(fan.getLowerThresholdCritical());
            hwFan.setMaxWarningThreshold(fan.getUpperThresholdNonCritical());
            hwFan.setMaxCriticalThreshold(fan.getUpperThresholdCritical());
            hwfanList.add(hwFan);
        }
        return hwfanList;
    }


    private static List<HwPsu> transformHwPowerSupply(List<PowerSupplyView> powerSupplies) {
        List<HwPsu> hwPsuList = new ArrayList<HwPsu>();
        if (CollectionUtils.isEmpty(powerSupplies)) {
            return hwPsuList;
        }
        HwPsu hwPsu;
        for (PowerSupplyView powerSupplyView : powerSupplies) {
            hwPsu = new HwPsu();
            hwPsu.setFirmwareVersion(powerSupplyView.getFirmwareVersion());
            hwPsu.setStatus(powerSupplyView.getPrimaryStatus());
            hwPsu.setFqdd(powerSupplyView.getfQDD());
            hwPsu.setPartNumber(powerSupplyView.getPartNumber());
            hwPsu.setType(powerSupplyView.getType());
            hwPsu.setManufacturer(powerSupplyView.getManufacturer());
            hwPsu.setSerialNumber(powerSupplyView.getSerialNumber());
            hwPsu.setName(powerSupplyView.getDeviceDescription());
            hwPsu.setRedundancyStatus(powerSupplyView.getRedundancyStatus());
            hwPsu.setInputWattage(powerSupplyView.getRange1MaxInputPower());
            hwPsu.setOutputWattage(powerSupplyView.getTotalOutputPower());
            hwPsu.setInputVoltage(powerSupplyView.getInputVoltage());
            // TODO: Mocked until idrac commands are built
            hwPsu.setInputAmps("10");
            hwPsuList.add(hwPsu);
        }

        return hwPsuList;
    }


    public static List<HwNic> transformHwNic(List<DCIMNICViewType> dcimnicViewTypes) {
        List<HwNic> hwNicList = new ArrayList<HwNic>();
        if (CollectionUtils.isEmpty(dcimnicViewTypes)) {
            return hwNicList;
        }
        HwNic hwNic;
        for (DCIMNICViewType dcimnicViewType : dcimnicViewTypes) {
            hwNic = new HwNic();
            hwNic.setBusNumber(dcimnicViewType.getBusNumber() != null ? String.valueOf(dcimnicViewType.getBusNumber().getValue()) : null);
            hwNic.setCurrentMACAddress(dcimnicViewType.getCurrentMACAddress() != null ? dcimnicViewType.getCurrentMACAddress().getValue() : null);
            hwNic.setDataBusWidth(dcimnicViewType.getDataBusWidth() != null ? dcimnicViewType.getDataBusWidth().getValue() : null);
            hwNic.setDeviceDescription(dcimnicViewType.getDescription() != null ? dcimnicViewType.getDescription().getValue() : null);
            hwNic.setDeviceNumber(dcimnicViewType.getDeviceNumber() != null ? String.valueOf(dcimnicViewType.getDeviceNumber().getValue()) : null);
            hwNic.setFqdd(dcimnicViewType.getFqdd() != null ? dcimnicViewType.getFqdd().getValue() : null);
            hwNic.setPciDeviceID(dcimnicViewType.getPciDeviceID() != null ? dcimnicViewType.getPciDeviceID().getValue() : null);
            hwNic.setPermanentFcoMacAddress(dcimnicViewType.getPermanentMACAddress() != null ? dcimnicViewType.getPermanentMACAddress().getValue() : null);
            hwNic.setProductName(dcimnicViewType.getProductName() != null ? dcimnicViewType.getProductName().getValue() : null);
            hwNic.setSlotLength(dcimnicViewType.getSlotLength() != null ? dcimnicViewType.getSlotLength().getValue() : null);
            hwNic.setSlotType(dcimnicViewType.getSlotType() != null ? dcimnicViewType.getSlotType().getValue() : null);
            hwNic.setAutoNegotiation(dcimnicViewType.getAutoNegotiation() != null ? dcimnicViewType.getAutoNegotiation().getValue() : null);
            hwNic.setControllerBiosVersion(dcimnicViewType.getControllerBIOSVersion() != null ? dcimnicViewType.getControllerBIOSVersion().getValue() : null);
            hwNic.setFamilyVersion(dcimnicViewType.getFamilyVersion() != null ? dcimnicViewType.getFamilyVersion().getValue() : null);
            hwNic.setLinkDuplex(dcimnicViewType.getLinkDuplex() != null ? dcimnicViewType.getLinkDuplex().getValue() : null);
            hwNic.setLinkSpeed(dcimnicViewType.getLinkSpeed() != null ? dcimnicViewType.getLinkSpeed().getValue() : null);
            hwNic.setMaxBandwidth(dcimnicViewType.getMaxBandwidth() != null ? dcimnicViewType.getMaxBandwidth().getValue() : null);
            hwNic.setNicMode(dcimnicViewType.getNicMode() != null ? dcimnicViewType.getNicMode().getValue() : null);
            hwNic.setPciSubDeviceID(dcimnicViewType.getPciSubVendorID() != null ? dcimnicViewType.getPciSubVendorID().getValue() : null);
            hwNic.setPermanentMacAddress(dcimnicViewType.getPermanentMACAddress() != null ? dcimnicViewType.getPermanentMACAddress().getValue() : null);
            hwNic.setPermanentiScsiMacAddress(dcimnicViewType.getPermanentiSCSIMACAddress() != null ? dcimnicViewType.getPermanentiSCSIMACAddress().getValue() : null);
            hwNic.setTransmitFlowControl(dcimnicViewType.getTransmitFlowControl() != null ? dcimnicViewType.getTransmitFlowControl().getValue() : null);
            hwNic.setVendorName(dcimnicViewType.getVendorName() != null ? dcimnicViewType.getVendorName().getValue() : null);
            hwNic.setVirtWwn(dcimnicViewType.getVirtWwn() != null ? dcimnicViewType.getVirtWwn().getValue() : null);
            hwNic.setVirtWwpn(dcimnicViewType.getVirtWwpn() != null ? dcimnicViewType.getVirtWwpn().getValue() : null);
            hwNic.setFCoEOffloadMode(dcimnicViewType.getfCoEOffloadMode() != null ? dcimnicViewType.getfCoEOffloadMode().getValue() : null);
            hwNic.setFCoEWwnn(dcimnicViewType.getfCoEWwnn() != null ? dcimnicViewType.getfCoEWwnn().getValue() : null);
            hwNic.setIscsiOffloadMode(dcimnicViewType.getiScsiOffloadMode() != null ? dcimnicViewType.getiScsiOffloadMode().getValue() : null);
            hwNic.setWwn(dcimnicViewType.getWwn() != null ? dcimnicViewType.getWwn().getValue() : null);
            hwNic.setWwpn(dcimnicViewType.getWwpn() != null ? dcimnicViewType.getWwpn().getValue() : null);
            hwNic.setMinBandwidth(dcimnicViewType.getMinBandwidth() != null ? dcimnicViewType.getMinBandwidth().getValue() : null);
            hwNic.setMediaType(dcimnicViewType.getMediaType() != null ? dcimnicViewType.getMediaType().getValue() : null);
            hwNic.setReceiveFlowControl(dcimnicViewType.getReceiveFlowControl() != null ? dcimnicViewType.getReceiveFlowControl().getValue() : null);
            hwNic.setLinkStatus(dcimnicViewType.getLinkStatus());
            hwNic.setOsDriverState(dcimnicViewType.getOsDriverState());
            hwNic.setMacAddress(dcimnicViewType.getMacAddress());
            hwNic.setIscsiMacAddress(dcimnicViewType.getIscsiMacAddress());
            hwNic.setVirtualMacAddress(dcimnicViewType.getVirtualMacAddress());
            hwNic.setVirtualIscsiMacAddress(dcimnicViewType.getVirtualIscsiMacAddress());
            hwNic.setFamilyDriverVersion(dcimnicViewType.getFamilyVersion() != null ? dcimnicViewType.getFamilyVersion().getValue() : null);
            hwNic.setTeaming("< NIC # > , < NIC # >");
            hwNic.setIscsiOffloadSupport(dcimnicViewType.getIscsiOffloadSupport());
            hwNic.setToeSupport(dcimnicViewType.getToeSupport());
            hwNic.setLegacyBootProtocol(dcimnicViewType.getLegacyBootProtocol());
            hwNic.setIscsiBootMode(dcimnicViewType.getIcsciBootMode());
            hwNic.setIscsiInitiatorIpAddress(dcimnicViewType.getIscsiInitiatorIpAddress());
            hwNic.setIscsiInitiatorSubnet(dcimnicViewType.getIscsiInitiatorSubnet());
            hwNic.setIscsiInitiatorGateway(dcimnicViewType.getIscsiInitiatorGateway());
            hwNic.setIscsiInitiatorPrimaryDns(dcimnicViewType.getIscsiInitiatorPrimaryDns());
            hwNic.setIscsiInitiatorSecondryDns(dcimnicViewType.getIscsiInitiatorSecondryDns());
            hwNic.setIscsiInitiatorName(dcimnicViewType.getIscsiInitiatorName());
            hwNicList.add(hwNic);
        }
        return hwNicList;
    }


    private static List<HwMemory> transformHwMemory(List<MemoryView> memories) throws Exception {
        List<HwMemory> hwMemoryList = new ArrayList<HwMemory>();
        if (CollectionUtils.isEmpty(memories)) {
            return hwMemoryList;
        }
        HwMemory hwMemory;
        for (MemoryView memoryView : memories) {
            hwMemory = new HwMemory();
            hwMemory.setBankLabel(memoryView.getBankLabel() != null ? memoryView.getBankLabel() : null);
            hwMemory.setCurrentOperatingSpeed(memoryView.getCurrentOperatingSpeed() != null ? memoryView.getCurrentOperatingSpeed() : null);
            hwMemory.setFqdd(memoryView.getfQDD() != null ? memoryView.getfQDD() : null);
            if (memoryView.getManufactureDate() != null) {
                hwMemory.setManufactureDate(DateTimeUtils.getIsoDateString(memoryView.getManufactureDate(), TransformerAssemblerConstants.DATE_PATTERNS));
            }
            hwMemory.setManufacturer(memoryView.getManufacturer() != null ? memoryView.getManufacturer() : null);
            hwMemory.setDeviceDescription(memoryView.getDeviceDescription() != null ? memoryView.getDeviceDescription() : null);
            hwMemory.setMemoryType(memoryView.getMemoryType() != null ? memoryView.getMemoryType() : null);
            hwMemory.setModel(memoryView.getModel() != null ? memoryView.getModel() : null);
            hwMemory.setPartNumber(memoryView.getPartNumber() != null ? memoryView.getPartNumber() : null);
            hwMemory.setPrimaryStatus(memoryView.getPrimaryStatus() != null ? memoryView.getPrimaryStatus() : null);
            hwMemory.setRank(memoryView.getRank() != null ? memoryView.getRank() : null);
            hwMemory.setSerialNumber(memoryView.getSerialNumber() != null ? memoryView.getSerialNumber() : null);
            // convert Memory Size and Speed to GB from MB
            try {
                hwMemory.setSize(memoryView.getSize() != null ? PatternUtils.megaBytesToGigaBytes(Double.parseDouble(memoryView.getSize())) : 0);
                hwMemory.setSpeed(memoryView.getSpeed() != null ? PatternUtils.megaBytesToGigaBytes(Double.parseDouble(memoryView.getSpeed())) : 0);
            } catch (NumberFormatException e) {
                logger.debug("GB conversion failed: double parse of part threw NumberFormatException (memory size not numeric)");
                hwMemory.setSize(0);
                hwMemory.setSpeed(0);
            }
            hwMemoryList.add(hwMemory);
        }
        return hwMemoryList;
    }


    public static HwSystem transformHwSystem(DCIMSystemViewType system) throws Exception {
        if (system == null) {
            return null;
        }
        HwSystem hwSystem = new HwSystem();
        hwSystem.setAssetTag(system.getAssetTag() != null ? system.getAssetTag().getValue() : null);
        hwSystem.setBatteryRollupStatus(system.getBatteryRollupStatus() != null ? String.valueOf(system.getBatteryRollupStatus().getValue()) : null);
        if (system.getBiosReleaseDate() != null) {
            hwSystem.setBiosReleaseDate(getIsoDateString(system.getBiosReleaseDate().getValue(), TransformerAssemblerConstants.DATE_PATTERNS));
        }
        hwSystem.setBiosVersionString(system.getBiosVersionString() != null ? system.getBiosVersionString().getValue() : null);
        hwSystem.setBoardPartNumber(system.getBoardPartNumber() != null ? system.getBoardPartNumber().getValue() : null);
        hwSystem.setBoardSerialNumber(system.getBoardSerialNumber() != null ? system.getBoardSerialNumber().getValue() : null);
        hwSystem.setChassisName(system.getChassisName() != null ? system.getChassisName().getValue() : null);
        hwSystem.setChassisServiceTag(system.getChassisServiceTag() != null ? system.getChassisServiceTag().getValue() : null);
        hwSystem.setChassisSystemHeight(system.getChassisSystemHeight() != null ? String.valueOf(system.getChassisSystemHeight().getValue()) : null);
        hwSystem.setCmcip(system.getCmcip() != null ? system.getCmcip().getValue() : null);
        hwSystem.setCurrentRollupStatus(system.getCurrentRollupStatus() != null ? String.valueOf(system.getCurrentRollupStatus().getValue()) : null);
        hwSystem.setCpldVersion(system.getCpldVersion() != null ? system.getCpldVersion().getValue() : null);
        hwSystem.setDeviceDescription(system.getDeviceDescription() != null ? system.getDeviceDescription().getValue() : null);
        hwSystem.setFqdd(system.getFqdd() != null ? system.getFqdd().getValue() : null);
        hwSystem.setHostName(system.getHostName() != null ? system.getHostName().getValue() : null);
        hwSystem.setInstanceID(system.getInstanceID() != null ? system.getInstanceID().getValue() : null);
        hwSystem.setLicensingRollupStatus(system.getLicensingRollupStatus() != null ? String.valueOf(system.getLicensingRollupStatus().getValue()) : null);
        hwSystem.setLifecycleControllerVersion(system.getLifecycleControllerVersion() != null ? system.getLifecycleControllerVersion().getValue() : null);
        hwSystem.setManufacturer(system.getManufacturer() != null ? system.getManufacturer().getValue() : null);
        hwSystem.setMaxCpuSockets(system.getMaxCPUSockets() != null ? String.valueOf(system.getMaxCPUSockets().getValue()) : null);
        hwSystem.setMaxDimmSlots(system.getMaxDIMMSlots() != null ? String.valueOf(system.getMaxDIMMSlots().getValue()) : null);
        hwSystem.setMaxPcieSlots(system.getMaxPCIeSlots() != null ? String.valueOf(system.getMaxPCIeSlots().getValue()) : null);
        hwSystem.setMemoryOperationMode(system.getMemoryOperationMode() != null ? system.getMemoryOperationMode().getValue() : null);
        hwSystem.setModel(system.getModel() != null ? system.getModel().getValue() : null);
        hwSystem.setPlatformGuid(system.getPlatformGUID() != null ? system.getPlatformGUID().getValue() : null);
        hwSystem.setPopulatedCpuSockets(system.getPopulatedCPUSockets() != null ? String.valueOf(system.getPopulatedCPUSockets().getValue()) : null);
        hwSystem.setPopulatedDimmSlots(system.getPopulatedDIMMSlots() != null ? String.valueOf(system.getPopulatedDIMMSlots().getValue()) : null);
        hwSystem.setPopulatedPcieSlots(system.getPopulatedPCIeSlots() != null ? String.valueOf(system.getPopulatedPCIeSlots().getValue()) : null);
        hwSystem.setPowerCap(system.getPowerCap() != null ? String.valueOf(system.getPowerCap().getValue()) : null);
        hwSystem.setPowerCapEnabledState(system.getPowerCapEnabledState() != null ? String.valueOf(system.getPowerCapEnabledState().getValue()) : null);
        hwSystem.setPowerState(system.getPowerState() != null ? String.valueOf(system.getPowerState().getValue()) : null);
        hwSystem.setPsRollupStatus(system.getPsRollupStatus() != null ? String.valueOf(system.getPsRollupStatus().getValue()) : null);
        hwSystem.setRollupStatus(system.getRollupStatus() != null ? String.valueOf(system.getRollupStatus().getValue()) : null);
        hwSystem.setServiceTag(system.getServiceTag() != null ? system.getServiceTag().getValue() : null);
        hwSystem.setSysMemLocation(system.getSysMemLocation() != null ? String.valueOf(system.getSysMemLocation().getValue()) : null);
        hwSystem.setSysMemErrorInfo(system.getSysMemErrorInfo() != null ? String.valueOf(system.getSysMemErrorInfo().getValue()) : null);
        hwSystem.setSysMemErrorMethodology(system.getSysMemErrorMethodology() != null ? String.valueOf(system.getSysMemErrorMethodology().getValue()) : null);
        hwSystem.setSysMemPrimaryStatus(system.getSysMemPrimaryStatus() != null ? String.valueOf(system.getSysMemPrimaryStatus().getValue()) : null);
        // convert Installed Capacity to GB from MB
        hwSystem.setSysMemTotalSize(system.getSysMemTotalSize() != null ? PatternUtils.megaBytesToGigaBytes(system.getSysMemTotalSize().getValue()) : 0);
        hwSystem.setSystemGeneration(system.getSystemGeneration() != null ? String.valueOf(system.getSystemGeneration().getValue()) : null);
        hwSystem.setSystemID(system.getSystemID() != null ? String.valueOf(system.getSystemID().getValue()) : null);
        hwSystem.setSysMemMaxCapacitySize(system.getSysMemMaxCapacitySize() != null ? String.valueOf(system.getSysMemMaxCapacitySize().getValue()) : null);
        hwSystem.setUuid(system.getUuid() != null ? system.getUuid().getValue() : null);
        hwSystem.setChassisModel(system.getChassisModel() != null ? system.getChassisModel().getValue() : null);
        hwSystem.setBaseBoardChassisSlot(system.getBaseBoardChassisSlot() != null ? system.getBaseBoardChassisSlot().getValue() : null);
        hwSystem.setBladeGeometry(system.getBladeGeometry() != null ? String.valueOf(system.getBladeGeometry().getValue()) : null);
        hwSystem.setCpuRollupStatus(system.getCpuRollupStatus() != null ? String.valueOf(system.getCpuRollupStatus().getValue()) : null);
        hwSystem.setCaption(system.getCaption() != null ? system.getCaption().getValue() : null);
        hwSystem.setExpressServiceCode(system.getExpressServiceCode() != null ? system.getExpressServiceCode().getValue() : null);
        hwSystem.setElementName(system.getElementName() != null ? system.getElementName().getValue() : null);
        hwSystem.setFanRollupStatus(system.getFanRollupStatus() != null ? String.valueOf(system.getFanRollupStatus().getValue()) : null);
        hwSystem.setGeneration(system.getGeneration() != null ? String.valueOf(system.getGeneration().getValue()) : null);
        hwSystem.setLastSystemInventoryTime(system.getLastSystemInventoryTime() != null ? system.getLastSystemInventoryTime().getValue() : null);
        hwSystem.setLastUpdateTime(system.getLastUpdateTime() != null ? system.getLastUpdateTime().getValue() : null);
        hwSystem.setPrimaryStatus(system.getPrimaryStatus() != null ? String.valueOf(system.getPrimaryStatus().getValue()) : null);
        hwSystem.setStorageRollupStatus(system.getStorageRollupStatus() != null ? String.valueOf(system.getStorageRollupStatus().getValue()) : null);
        hwSystem.setSysMemFailOverState(system.getSysMemFailOverState() != null ? system.getSysMemFailOverState().getValue() : null);
        hwSystem.setSystemRevision(system.getSystemRevision() != null ? String.valueOf(system.getSystemRevision().getValue()) : null);
        hwSystem.setTempRollupStatus(system.getTempRollupStatus() != null ? String.valueOf(system.getTempRollupStatus().getValue()) : null);
        hwSystem.setVoltRollupStatus(system.getVoltRollupStatus() != null ? String.valueOf(system.getVoltRollupStatus().getValue()) : null);
        hwSystem.setSmbiosGUID(system.getSmbiosGUID() != null ? system.getSmbiosGUID().getValue() : null);
        hwSystem.setNodeId(system.getNodeId() != null ? system.getNodeId().getValue() : null);
        hwSystem.setEstimatedExhaustTemperature(system.getEstimatedExhaustTemperature() != null ? String.valueOf(system.getEstimatedExhaustTemperature().getValue()) : null);
        hwSystem.setEstimatedSystemAirflow(system.getEstimatedSystemAirflow() != null ? String.valueOf(system.getEstimatedSystemAirflow().getValue()) : null);
        hwSystem.setServerAllocation(system.getServerAllocation() != null ? String.valueOf(system.getServerAllocation().getValue()) : null);
        hwSystem.setTempStatisticsRollupStatus(system.getTempStatisticsRollupStatus() != null ? String.valueOf(system.getTempStatisticsRollupStatus().getValue()) : null);
        hwSystem.setIdsdmRollupStatus(system.getIdsdmRollupStatus() != null ? String.valueOf(system.getIdsdmRollupStatus().getValue()) : null);
        hwSystem.setMemoryRollupStatus(system.getMemoryRollupStatus() != null ? String.valueOf(system.getMemoryRollupStatus().getValue()) : null);

        return hwSystem;
    }

    public static List<IdracCardString> transformIdracString(List<IDRACCardStringView> isvList) throws Exception {
        List<IdracCardString> icsList= new ArrayList<>();
        if (CollectionUtils.isEmpty(isvList)) {
            return icsList;
        }

        for (IDRACCardStringView icsv : isvList) {
            IdracCardString ics = new IdracCardString();
            ics.setAttributeDisplayName(icsv.getAttributeDisplayName());
            ics.setAttributeName(icsv.getAttributeName());
            ics.setCurrentValue(icsv.getCurrentValue());
            ics.setDefaultValue(icsv.getDefaultValue());
            ics.setDependency(icsv.getDependency());
            ics.setDisplayOrder(icsv.getDisplayOrder());
            ics.setFqdd(icsv.getfQDD());
            ics.setGroupDisplayName(icsv.getGroupDisplayName());
            ics.setGroupId(icsv.getGroupID());
            ics.setInstanceId(icsv.getInstanceID());
            ics.setIsReadOnly(icsv.getIsReadOnly());
            ics.setMaxLength(icsv.getMaxLength());
            ics.setMinLength(icsv.getMinLength());
            ics.setPendingValue(icsv.getPendingValue());
            icsList.add(ics);
        }
        return icsList;
    }

}
