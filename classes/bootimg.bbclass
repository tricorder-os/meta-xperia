inherit kernel

# must be defined in machine config
KERNEL_CMDLINE ?= "clk_ignore_unused console=ttyMSM0,115200,n8"
KERNEL_RAMBASE ?= ""
KERNEL_PAGESIZE ?= ""
RAMDISK_OFFSET ?= ""
TAGS_OFFSET ?= ""

DEPENDS += " \
  mkbootimg-native \
  "

BOOTIMG_BASE_NAME ?= "${PKGV}-${PKGR}-${MACHINE}-${DATETIME}"
BOOTIMG_BASE_NAME[vardepsexclude] = "DATETIME"

do_deploy_append() {
  cat ${B}/${KERNEL_OUTPUT_DIR}/${KERNEL_IMAGETYPE} \
    ${B}/${KERNEL_OUTPUT_DIR}/dts/${KERNEL_DEVICETREE} > \
    ${B}/${KERNEL_OUTPUT_DIR}/${KERNEL_IMAGETYPE}-dtb

  dd if=/dev/zero of=${WORKDIR}/dummy.img bs=4096 count=1

  mkbootimg \
    --kernel ${B}/${KERNEL_OUTPUT_DIR}/${KERNEL_IMAGETYPE}-dtb \
    --cmdline "${KERNEL_CMDLINE}" \
    --ramdisk ${WORKDIR}/dummy.img \
    --base ${KERNEL_RAMBASE} \
    --pagesize ${KERNEL_PAGESIZE} \
    --ramdisk_offset ${RAMDISK_OFFSET} \
    --tags_offset ${TAGS_OFFSET} \
    --output ${WORKDIR}/boot.img \
    --board ${MACHINE}

  install ${B}/${KERNEL_OUTPUT_DIR}/${KERNEL_IMAGETYPE}-dtb \
    ${DEPLOY_DIR_IMAGE}/${KERNEL_IMAGETYPE}-dtb-${BOOTIMG_BASE_NAME}.bin

  install ${WORKDIR}/boot.img \
    ${DEPLOY_DIR_IMAGE}/boot-${BOOTIMG_BASE_NAME}.img

  ln -sf ${KERNEL_IMAGETYPE}-dtb-${BOOTIMG_BASE_NAME}.bin \
    ${DEPLOY_DIR_IMAGE}/${KERNEL_IMAGETYPE}-dtb-${MACHINE}.bin

  ln -sf boot-${BOOTIMG_BASE_NAME}.img \
    ${DEPLOY_DIR_IMAGE}/boot-${MACHINE}.img

  ln -sf boot-${BOOTIMG_BASE_NAME}.img \
    ${DEPLOY_DIR_IMAGE}/boot.img
}
