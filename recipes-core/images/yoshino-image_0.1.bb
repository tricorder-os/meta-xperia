SUMMARY = "yoshino sony xperia image"
LICENSE = "MIT"

IMAGE_FEATURES += " \
  package-management \
  "

inherit core-image

IMAGE_INSTALL += " \
  packagegroup-core-ssh-dropbear \
  packagegroup-xperia-cli \
  "
