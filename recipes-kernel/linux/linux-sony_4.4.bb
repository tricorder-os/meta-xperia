DESCRIPTION = "Sony Xperia Linux Kernel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

inherit kernel

require recipes-kernel/linux/linux-dtb.inc

DEPENDS += " \
  lzop-native \
  linux-firmware \
  bc-native \
  "

RDEPENDS_kernel-base += "kernel-modules"
RDEPENDS_kernel-base += "kernel-devicetree"

BRANCH = "aosp/LA.UM.5.7.r1"

SRCREV_kernel = "4d1a7c8d246d89c45c25dbe95f25480944055adc"
SRCREV_qcacld = "f742ce4fd5d54d0dfa13a797ce2444ad29b9deae"
SRCREV_fw-api = "764f0d9adc52cb0049db62e3c704a5d0d5c8d70a"
SRCREV_qca-wifi-host-cmn = "d502fccacc86d7cb4b08907b54cfa8494c8eaa6d"

SRC_URI = " \
  git://github.com/sonyxperiadev/kernel.git;protocol=https;branch=${BRANCH};destsuffix=linux-${PV};name=kernel \
  git://github.com/esno/qcom-wlan-qcacld-3.0.git;protocol=https;branch=${BRANCH};destsuffix=linux-${PV}/drivers/staging/wlan-qc/qcacld-3.0;name=qcacld \
  git://github.com/sonyxperiadev/vendor-qcom-opensource-wlan-fw-api.git;protocol=https;branch=${BRANCH};destsuffix=linux-${PV}/drivers/staging/wlan-qc/fw-api;name=fw-api \
  git://github.com/sonyxperiadev/vendor-qcom-opensource-wlan-qca-wifi-host-cmn.git;protocol=https;branch=${BRANCH};destsuffix=linux-${PV}/drivers/staging/wlan-qc/qca-wifi-host-cmn;name=qca-wifi-host-cmn \
  "

S = "${WORKDIR}/linux-${PV}"

do_configure_append() {
  oe_runmake ${KERNEL_DEFCONFIG}
}
